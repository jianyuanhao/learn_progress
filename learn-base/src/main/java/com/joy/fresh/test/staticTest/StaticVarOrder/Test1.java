package com.joy.fresh.test.staticTest.StaticVarOrder;

/**
 * Created by jianyuanhao on 18-5-2.
 */
public class Test1 {
    public Test1() {

        System.out.println("Go in Test1: " + Test.a + Test.b);
        Test.a++;
        Test.b++;
        System.out.println("End in Test1: " + Test.a + Test.b);
    }
}
