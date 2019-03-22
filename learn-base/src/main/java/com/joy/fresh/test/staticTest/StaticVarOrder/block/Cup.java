package com.joy.fresh.test.staticTest.StaticVarOrder.block;

/**
 * Created by jianyuanhao on 18-5-2.
 */
class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}
