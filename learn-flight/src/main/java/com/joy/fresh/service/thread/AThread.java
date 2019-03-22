package com.joy.fresh.service.thread;

/**
 * Created by jianyuanhao on 18-4-17.
 */
class AThread extends Thread {

    BThread bt;

    public AThread(BThread bt) {

        super("[AThread] Thread");

        this.bt = bt;

    }

    public void run() {

        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " start.");

        try {

            bt.join();

            System.out.println(threadName + " end.");

        } catch (Exception e) {

            System.out.println("Exception from " + threadName + ".run");

        }

    }

}
