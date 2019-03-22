package com.joy.fresh.test.JVM;

/**
 * @author 诸葛 两个object为了加锁使用 分别开两个线程 １，开始，锁 2
 */
public class DeadLockTest {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    try {
                        System.out.println("thread1 begin");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    }
                    synchronized (lock2) {
                        System.out.println("thread1 end");
                    }
                }
            }

        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    try {
                        System.out.println("thread2 begin");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                    }
                    synchronized (lock1) {
                        System.out.println("thread2 end");
                    }
                }
            }
        }).start();

        System.out.println("main thread end");
    }
}
