package com.joy.fresh.test.JVM;

/**
 * Created by jianyuanhao on 18-10-28.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.sun.crypto.provider.DESKeyFactory;
import java.lang.String;

public class TestJDKClassLoader {
    public TestJDKClassLoader() {
    }

    public static void main(String[] args) {
        //启动类加载器： jre/lib/rt.jar－－负责加载JRE的核心类库，如jre目标下的rt.jar,charsets.jar等
        System.out.println(String.class.getClassLoader());
        // 扩展类加载器：负责加载JRE扩展目录ext中JAR类包-jre/lib/ext里的
        System.out.println(DESKeyFactory.class.getClassLoader().getClass().getName());
        // 系统（应用的）类加载器－业务代码类
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
        // 系统（应用的）类加载器打印
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
    }
}
