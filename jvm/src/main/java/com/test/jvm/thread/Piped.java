package com.test.jvm.thread;

import cn.hutool.core.io.IoUtil;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {
    public static void main(String[] args) throws Exception {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        // 将输出流和输入流进行连接，否则在使用时会抛出IOException
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.join();
        printThread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   for(int i=0;i<5;i++){
                       out.write(i+"");
                   }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    IoUtil.close(out);
                }
            }
        }).start();

    }

    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.println(Thread.currentThread().getName() + ":" + (char) receive);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}