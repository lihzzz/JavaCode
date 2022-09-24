package com.learn.bench;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

public class BIOBechmark extends BenchBase{

    private ServerSocket serverSocket;
    private Socket socketForServer;
    private Socket socketForClient;
    private Thread serverReadThread;
    private Thread clientReadThread;
    private DataOutputStream serverOutputStream;
    private DataOutputStream clientOutputStream;
    private ConcurrentHashMap<Long, BiConsumer<Long,String>> requestCallBack = new ConcurrentHashMap<>();
    private ExecutorService serverExecutor = Executors.newFixedThreadPool(100);
    private long requestId;

    public BIOBechmark(int threadCount, long time) {
        super(threadCount, time);
    }

    @Override
    public void init() throws Exception {
        int port = 23456;
        serverSocket = new ServerSocket(port);
        new Thread(() ->{
            try {
                socketForServer = serverSocket.accept();
                serverOutputStream = new DataOutputStream(socketForServer.getOutputStream());
                serverReadThread = new Thread(this::serverReadLoop);
                serverReadThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        socketForClient = new Socket("127.0.0.1",port);
        clientOutputStream = new DataOutputStream(socketForClient.getOutputStream());
        clientReadThread = new Thread(this::clientReadLoop);
        clientReadThread.start();
    }

    @Override
    public void test(int threadIndex) {
        synchronized (clientOutputStream){
            requestId++;
            requestCallBack.put(requestId,(header,body)->{
                if(!stop){
                    successCount.add(1);
                }
            });
            try {
                clientOutputStream.writeLong(requestId);
                clientOutputStream.writeUTF("hello");
                clientOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void serverReadLoop(){
        try {
            DataInputStream dis = new DataInputStream(socketForServer.getInputStream());
            while(!stop){
                long header = dis.readLong();
                String body = dis.readUTF();
                serverExecutor.submit(()->{
                    try {
                        serverWrite(header,body);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server read thread exit");
    }

    private void clientReadLoop(){
        try {
            DataInputStream dis = new DataInputStream(socketForClient.getInputStream());
            while (!stop){
                long header = dis.readLong();
                String body = dis.readUTF();
                BiConsumer<Long,String> callback = requestCallBack.remove(header);
                if(callback != null){
                    callback.accept(header,body);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("client read thread exit");
    }

    private void serverWrite(long header,String body) throws IOException {
        synchronized (serverOutputStream){
            serverOutputStream.writeLong(header);
            serverOutputStream.writeUTF(body);
            serverOutputStream.flush();
        }
    }

    public static void main(String[] args) throws Exception {
        new BIOBechmark(64,10000).start();
    }
}
