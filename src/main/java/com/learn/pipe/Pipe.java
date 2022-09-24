package com.learn.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Pipe {

    public static void main(String[] args) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        pipedInputStream.connect(pipedOutputStream);

        Runnable runnable = () -> produceData(pipedOutputStream);
        Runnable in = () -> consumeData(pipedInputStream);
        new Thread(runnable).start();
        new Thread(in).start();
    }

    public static void produceData(PipedOutputStream pipedOutputStream){
        try {
            for (int i = 0; i < 50; i++) {
                pipedOutputStream.write(i);
                pipedOutputStream.flush();
                System.out.println("write: " + i);
                Thread.sleep(500);
            }
            pipedOutputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void consumeData(PipedInputStream pipedInputStream){
        try {
            int num = -1;
            while((num = pipedInputStream.read()) != -1){
                System.out.println("reading: " + num);
            }
            pipedInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
