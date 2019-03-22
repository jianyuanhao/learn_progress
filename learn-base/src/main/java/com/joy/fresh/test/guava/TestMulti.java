package com.joy.fresh.test.guava;

import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Guava Collections 还提供了各种 Immutable 集合的实现：
 * ImmutableSet,ImmutableList，ImmutableMap，ImmutableSortedSet，ImmutableSortedMap。
 * Created by jianyuanhao on 18-5-24.
 */
public class TestMulti {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>(Arrays.asList(new String[] { "RED", "GREEN" }));
        Set<String> unmodifiableSet = Collections.unmodifiableSet(set);
        System.out.println(unmodifiableSet);//[RED, GREEN]
        // unmodifiableSet.add("BLUE");
        // 因为每次调 unmodifiableSet.add() 都会抛出一个 UnsupportedOperationException。感觉安全了？慢！如果有人在原来的 set 上 add 或者 remove
        // 元素会怎么样？结果
        // unmodifiableSet 也是被 add 或者 remove 元素了。而且构造这样一个简单的 set 写了两句长的代码
        set.add("BLUE");
        System.out.println(unmodifiableSet);//[RED, BLUE, GREEN]

        ImmutableSet<String> immutableSet = ImmutableSet.of("RED", "GREEN");
        System.out.println(immutableSet);//[RED, GREEN]


        Set<String> set1 = new HashSet<String>(Arrays.asList(new String[] { "RED", "GREEN" }));
        ImmutableSet<String> immutableSetProtect = ImmutableSet.copyOf(set1);
        System.out.println(set1);//[RED, GREEN]
        set1.add("BLACK");
        System.out.println(set1);//[RED,  BLACK, GREEN]
        System.out.println(immutableSetProtect);//[RED, GREEN]

        ImmutableSet.Builder<String> builder = ImmutableSet.builder();
        immutableSet = builder.add("YELLOW").addAll(set).build();
        System.out.println(immutableSet);//[YELLOW, RED, BLUE, GREEN]

    }

}
