package com.joy.fresh.test.staticTest.StaticVarOrder;

/**
 * Created by jianyuanhao on 18-5-2.
 * http://www.jb51.net/article/86629.htm
 * Java静态变量初始化遵循以下规则:
 * 静态变量会按照声明的顺序先依次声明并设置为该类型的默认值，但不赋值为初始化的值。
 声明完毕后,再按声明的顺序依次设置为初始化的值，如果没有初始化的值就跳过。
 */
public class Test {
    public static Test1 t = new Test1();
    public static int a = 0;
    public static int b;

    public static void main(String[] arg)
    {
        System.out.println("Go in Main: " + Test.a + Test.b);
        System.out.println(Test.a);
        System.out.println(Test.b);
    }
}
