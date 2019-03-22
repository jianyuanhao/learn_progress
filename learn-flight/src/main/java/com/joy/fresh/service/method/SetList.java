package com.joy.fresh.service.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by jianyuanhao on 18-4-6.
 */
public class SetList {
    public static void main(String[] args) {
        Set<Integer> s = new TreeSet<Integer>();
        List<Integer> l = new ArrayList<Integer>();
        for (int i = -3; i < 3; ++i) {
            s.add(i);
            l.add(i);
        }
        System.out.println(s);
        System.out.println(l);
        for (int i = 0; i < 3; ++i) {
            s.remove(i);
//            l.remove(i);
            //我们需要让List明确的知道，
            // 我们需要调用的是remove(E)重载函数，
            // 而不是其他的，这样我们就需要对原有代码进行如下的修改：
            l.remove((Integer)i); //or remove(Integer.valueOf(i));
        }
        System.out.println(s + " " + l);
    }
}
