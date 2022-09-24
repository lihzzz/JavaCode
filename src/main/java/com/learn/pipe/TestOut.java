package com.learn.pipe;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class TestOut implements Runnable{

    private Process p ;
    private byte[] b ;

    public TestOut(Process p, byte[] b) {
        this.p = p;
        this.b = b;
    }




    @Override
    public void run() {
        OutputStream outputStream = p.getOutputStream();
        try {
            outputStream.write(b);
            List<Integer> a = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
