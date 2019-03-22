package com.joy.fresh.config;

/**
 * Created by jianyuanhao on 19-1-22.
 */
public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            final int threadIndex = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(threadIndex + "th job " + j + "th number");
                    }
                }
            });
            // 设置为后台线程 －随主线程完成而完成
            // thread.setDaemon(true);
            thread.start();
        }
        try {
            //主线程无法得其他线程的情况，死等，如何协调？join
            Thread.sleep(2000L);
            System.out.println("I think other threads has finished...");
        } catch (Exception e) {

        }
    }
}
