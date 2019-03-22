//package com.joy.fresh.mode.construct.SimpleFactoryPattern.right;
//
///**
// * Created by jianyuanhao on 18-8-7.
// * 在创建具体Chart对象时，每更换一个Chart对象都需要修改客户端代码中静态工厂方法的参数，
// * 客户端代码将要重新编译，这对于客户端而言，违反了“开闭原则”，有没有一种方法能够
// * 在不修改客户端代码的前提下更换具体产品对象呢？答案是肯定的，下面将介绍一种常用的实现方式。
//
// 我们可以将静态工厂方法的参数存储在XML或properties格式的配置文件中，如下config.xml所示：
// */
//public class Client {
//    public static void main(String args[]) {
//        Chart chart;
//        //通过静态工厂方法创建产品
////        chart = ChartFactory.getChart("histogram");
//        String type = XMLUtil.getChartType(); //读取配置文件中的参数
//        chart = ChartFactory.getChart(type); //创建产品对象
//
//        chart.display();
//    }
//}
