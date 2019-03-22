package com.joy.fresh.test.staticTest.StaticVarOrder.ObjectStatic;

/**
 * Created by jianyuanhao on 18-5-2. Java允许以类作为静态成员变量的类型，那么静态成员变量就是一个对象。 如果是基本数据类型的静态成员变量，在类的外部可以不必创建对象就直接使用。
 * 但如果静态成员是对象，问题就要复杂得多。因为对象所属的类，既可能有静态成员，也可能有实例成员。 而其中的实例成员必须要在对象实例化后才能使用，问题的核心在于：系统是否会为静态的类变量创建实例
 */
public class hasStatMember {
    /**
     * 这是静态方法
     * 
     * Exception in thread "main" java.lang.NullPointerException
     * 
     * at hasStatMember.main(hasStatMember.java:5)
     * 
     * 从运行结果中可以看出，静态方法被正常执行，但实例方法不能执行，原因是未创建对象实例。
     * 这说明尽管stVar被声明成static类型，系统仍然不会自动为它创建对象，所以程序必须改成如下内容才能正常运行：
     */
   // static supplyTest stVar; // 定义一个静态成员

    static supplyTest stVar = new supplyTest();     //定义一个静态成员并实例化它

    public static void main(String args[]) {

        stVar.statShow(); // 调用静态方法

        stVar.instShow(); // 调用实例方法

    }

}
