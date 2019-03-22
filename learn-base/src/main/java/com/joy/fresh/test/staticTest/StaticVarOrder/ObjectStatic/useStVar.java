package com.joy.fresh.test.staticTest.StaticVarOrder.ObjectStatic;

/**
 * Created by jianyuanhao on 18-5-2.
 * 无论是静态方法还是实例方法，都是通过“类名.静态变量名.方法名”的形式来使用的。
 * 读者可能会觉得这种形式有点眼熟。确实如此，前面大量使用的“System.out.println”就是这种形式。
 * 其中，System是系统预定义好的一个类，out是它的一个静态成员，println是out的一个实例方法。
 */
public class useStVar{

    public static void main(String args[]){

        hasStatMember.stVar.statShow();     //调用静态方法

        hasStatMember.stVar.instShow();     //调用实例方法

    }

}
