package com.joy.fresh.mode.construct.SimpleFactoryPattern.right;

/**
 * Created by jianyuanhao on 18-8-7.
 */
public class HistogramChart implements Chart {
    @Override
    public void display() {
        System.out.println("显示柱状图！");
    }
    public HistogramChart() {
        System.out.println("创建柱状图！");
    }


}
