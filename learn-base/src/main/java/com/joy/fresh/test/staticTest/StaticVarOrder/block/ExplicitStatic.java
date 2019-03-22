package com.joy.fresh.test.staticTest.StaticVarOrder.block;

/**
 * Created by jianyuanhao on 18-5-2. 显示的静态初始化（也就是静态块）
 * 把多个初始化语句包在一个static花括号里，叫做静态块，其实就是把多个static合在一起写了，
 * 本质是一样的。只有首次创建对象或者首次访问类的字段时才会执行，而且仅仅一次。

 *
 * 在类中，可以将某一块代码声明为静态的，这样的程序块叫静态初始化段。静态代码块的一般形式如下：

 static {

 语句序列

 }

 ●     静态代码块只能定义在类里面，它独立于任何方法，不能定义在方法里面。

 ●     静态代码块里面的变量都是局部变量，只在本块内有效。

 ●     静态代码块会在类被加载时自动执行，而无论加载者是JVM还是其他的类。

 ●     一个类中允许定义多个静态代码块，执行的顺序根据定义的顺序进行。

 ●     静态代码块只能访问类的静态成员，而不允许访问实例成员。
 */
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup1.f(99); // (1)
    }
//    * Inside main()
//    * Cup(1)
//    * Cup(2)
//    * f(99)

    // static Cups cups1 = new Cups(); // (2)
    // static Cups cups2 = new Cups(); // (2)
}
