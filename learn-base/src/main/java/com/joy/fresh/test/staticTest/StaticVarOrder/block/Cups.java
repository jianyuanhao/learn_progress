package com.joy.fresh.test.staticTest.StaticVarOrder.block;

/**
 * Created by jianyuanhao on 18-5-2.
 */
public class Cups {
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }

}
