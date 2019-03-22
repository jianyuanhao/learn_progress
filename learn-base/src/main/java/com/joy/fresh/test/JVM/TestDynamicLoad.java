package com.joy.fresh.test.JVM;

/**
 * Created by jianyuanhao on 18-10-28.
 */
public class TestDynamicLoad {
    static {
        System.out.println("*************static code************");
    }

    public TestDynamicLoad() {
    }

    public static void main(String[] args) {
        new A();
        System.out.println("*************load test************");
        new B();
    }
}
