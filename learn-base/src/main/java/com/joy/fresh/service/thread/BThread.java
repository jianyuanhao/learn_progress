package com.joy.fresh.service.thread;

/**
 * Created by jianyuanhao on 18-4-17.
 */
class BThread extends Thread {

    public BThread() {

        super("[BThread] Thread");

    };

    public void run() {

        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " start.");

        try {

            for (int i = 0; i < 5; i++) {

                System.out.println(threadName + " loop at " + i);

                Thread.sleep(1000);

            }

            System.out.println(threadName + " end.");

        } catch (Exception e) {

            System.out.println("Exception from " + threadName + ".run");

        }

    }
}
