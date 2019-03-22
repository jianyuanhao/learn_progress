package com.joy.fresh.test.staticTest.StaticVarOrder.complex;

/**
 * Created by jianyuanhao on 18-5-2.
 * http://www.jb51.net/article/86629.htm
 * 只有主动请求一个类,这个类才会初始化,仅包含静态变量,函数,等静态的东西.
 继承关系时,先初始化父类,后初始化子类.
 静态变量会按照声明的顺序先依次声明并设置为该类型的默认值,但不赋值为初始化的值.
 声明完毕后,再按声明的顺序依次设置为初始化的值,如果没有初始化的值就跳过.
 当初始化A.b=B.a时,暂停初始化A.b,设置当前类为B,跳到步骤3,并执行.
 当初始化B.plus = new A时,暂停初始化B.plus,实例化A并赋值给B.plus.
 当A的构造函数里需要获得B.a的值时,B.a还初始化并处于暂停初始化状态,直接取B.a的当前值,不再等待B.a初始化.
 final,静态常量其实是遵循普通静态变量的初始化的,但是在编译时,编译器会将不可变的常量值在使用的地方替换掉.可以用Java反编译工具查看.
 */
public class A
{
    public static int b = B.a;
    public static A plus =new A("A");
    public static final int finalInt = (int)(Math.random()*100);
    public static B p = new B("A");

    public static final String finalStr = "finalStr";
    public static final Integer finalInteger = new Integer(10);
    public static int a = 1;
    public static B c = null;

    public A(String from)
    {
        System.out.println("----------- begin A::A ----------------");
        System.out.println("A::A, from="+from);
        System.out.println("A::A, A.b="+A.b);
        System.out.println("A::A, A.finalInt="+A.finalInt);
        System.out.println("A::A, B.a="+B.a);
        System.out.println("A::A, B.plus="+B.plus);
        System.out.println("----------- end A::A ----------------");
    }

    public static void main(String[] arg)
    {
        System.out.println("main, A.b="+A.b);
        System.out.println("main, B.t="+B.t);
        System.out.println("main, C.a="+C.a);
        /**
         *     ----------- begin A::A ----------------
         A::A, from=B
         Disconnected from the target VM, address: '127.0.0.1:48533', transport: 'socket'
         A::A, A.b=0
         A::A, A.finalInt=0
         A::A, B.a=0
         A::A, B.plus=null
         ----------- end A::A ----------------
         ----------- begin A::A ----------------
         A::A, from=A
         A::A, A.b=1
         A::A, A.finalInt=0
         A::A, B.a=1
         A::A, B.plus=com.joy.fresh.test.staticTest.StaticVarOrder.complex.A@5e91993f
         ----------- end A::A ----------------
         ----------- begin B::B ----------------
         B::B, from=A
         B::B, B.a=1
         B::B, A.a=0
         B::B, A.p=null
         B::B, A.plus=com.joy.fresh.test.staticTest.StaticVarOrder.complex.A@cac736f
         B::B, A.finalInt=51
         B::B, A.finalInteger=null
         B::B, A.finalStr=finalStr
         ----------- end B::B ----------------
         main, A.b=1
         main, B.t=0
         ----------- begin A::A ----------------
         A::A, from=C
         A::A, A.b=1
         A::A, A.finalInt=51
         A::A, B.a=1
         A::A, B.plus=com.joy.fresh.test.staticTest.StaticVarOrder.complex.A@5e91993f
         ----------- end A::A ----------------
         main, C.a=com.joy.fresh.test.staticTest.StaticVarOrder.complex.A@156643d4
         */
    }

}
