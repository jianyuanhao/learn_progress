package com.joy.fresh.test.guava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;

/**
 * 常用实现 Multiset 接口的类有：
 HashMultiset: 元素存放于 HashMap
 LinkedHashMultiset: 元素存放于 LinkedHashMap，即元素的排列顺序由第一次放入的顺序决定
 TreeMultiset:元素被排序存放于TreeMap
 EnumMultiset: 元素必须是 enum 类型
 ImmutableMultiset: 不可修改的 Mutiset
 * Created by jianyuanhao on 18-5-24.
 */
public class MultiSetTest {
    public static void main(String[] args) {
        List<String> wordList = Lists.newArrayList("car", "ship", "bike", "the", "the", "cat");
        testListCount(wordList);
        testMultiSet(wordList);
    }

    /**
     * 连循环都不用了，而且 Multiset 用的方法叫 count，
     * 显然比在 Map 里面调 get 有更好的可读性。
     * @param wordList
     */
    private static void testMultiSet(List<String> wordList) {
        HashMultiset<String> multiSet = HashMultiset.create();
        multiSet.addAll(wordList);
        Integer count = multiSet.count("the");
        System.out.println(count);
    }

    private static void testListCount(List<String> wordList) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String word : wordList) {
            Integer count = map.get(word);
            map.put(word, (count == null) ? 1 : count + 1);
        }
        // count word “the”
        Integer count = map.get("the");
        System.out.println(count);
    }
}
