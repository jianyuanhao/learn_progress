package com.joy.fresh.test.staticTest.StaticVarOrder.complex;

/**
 * Created by jianyuanhao on 18-5-2.
 */
public class B {
    public static int t = A.a;
    public static A plus = new A("B");
    public static int a = 1;

    public B(String from) {
        System.out.println("----------- begin B::B ----------------");
        System.out.println("B::B, from=" + from);
        System.out.println("B::B, B.a=" + B.a);
        System.out.println("B::B, A.a=" + A.a);
        System.out.println("B::B, A.p=" + A.p);
        System.out.println("B::B, A.plus=" + A.plus);
        System.out.println("B::B, A.finalInt=" + A.finalInt);
        System.out.println("B::B, A.finalInteger=" + A.finalInteger);
        System.out.println("B::B, A.finalStr=" + A.finalStr);
        System.out.println("----------- end B::B ----------------");
    }
}