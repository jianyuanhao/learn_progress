package com.joy.fresh.service.thread;

/**
 * Created by jianyuanhao on 18-4-17.
 */
public class TestDemo {
//join阻塞等待另一个线程完成 才向下执行本线程其余代码.
// https://blog.csdn.net/cyp331203/article/details/40824499
    public static void main(String[] args) {

        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " start.");

        BThread bt = new BThread();

        AThread at = new AThread(bt);

        try {

            bt.start();

            Thread.sleep(2000);

            at.start();

//            at.join(); //在此处注释掉对join()的调用

        } catch (Exception e) {

            System.out.println("Exception from main");

        }

        System.out.println(threadName + " end!");

    }

}
