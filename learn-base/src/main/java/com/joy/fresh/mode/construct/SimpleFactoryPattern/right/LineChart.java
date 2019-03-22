package com.joy.fresh.mode.construct.SimpleFactoryPattern.right;

/**
 * Created by jianyuanhao on 18-8-7.
 */
//折线图类：具体产品类
class LineChart implements Chart {
    public LineChart() {
        System.out.println("创建折线图！");
    }

    public void display() {
        System.out.println("显示折线图！");
    }
}

