package com.joy.fresh.config;

/**
 * Created by jianyuanhao on 19-1-22.
 */
public class ThreadJoinDemo {
    public static void main(String[] args) {
        int threadCount = 5;
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            final int threadIndex = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(threadIndex + "th job " + j + "th number");
                    }
                }
            });
            threads[i] = thread;
            thread.start();
        }
        try {
            for (Thread thread : threads) {
                //调用方等待当前结束　否则阻塞　
                thread.join();
            }
            //threads里的都结束紧接着执行这句
            System.out.println("sub thread's jobs are done!");
        } catch (Exception e) {

        }
    }
}
