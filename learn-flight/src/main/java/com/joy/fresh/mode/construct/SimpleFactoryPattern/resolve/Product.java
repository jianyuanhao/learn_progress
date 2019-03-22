package com.joy.fresh.mode.construct.SimpleFactoryPattern.resolve;

/**
 * Created by jianyuanhao on 18-8-7.
 */
public abstract class Product {
    //所有产品类的公共业务方法
    public void methodSame() {
        //公共方法的实现
    }

    //声明抽象业务方法
    public abstract void methodDiff();
}

