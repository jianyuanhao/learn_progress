package com.joy.fresh.test.JVM;

import java.lang.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianyuanhao on 18-10-27.
 */
public class Math {
    public static final Integer CONSTANT_1 = 666;

    public int math() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        // 常用元素
        Math math = new Math();
        System.out.println(math.math());
        // 动态链接
        Map<String, String> map = new HashMap<String, String>();
        map.put("test","test");
        // 本地方法栈-native方法底层实现用C语言（先出现的语言）写的－通过这个接口去调用c,现在很少用了
        new Thread().start();
        //private native void start0();
    }
}
