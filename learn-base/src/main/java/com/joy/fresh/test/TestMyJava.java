package com.joy.fresh.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jianyuanhao on 17-7-10.
 */
public class TestMyJava {
    Set<String> exaltation = new HashSet<String>();
    @SuppressWarnings("unchecked")
    Set<String> exaltation1 = new HashSet();

    // 首先就是数组是协变的
    // 数组是具体化的，因此数组会在运行时才知道并检查它们的元素类型约束。
    // 如将一个String对象存储在Long的数组中时，就会得到一个ArrayStoreException异常。
    Object[] objArray = new Long[10];

    // 泛型是不可协变的
    // 相比之下，泛型则是通过擦除来实现的。因此泛型只是在编译时强化类型信息，并在运行时丢弃它们的元素类型信息。
    // 擦除就是使泛型可以与没有使用泛型的代码随意进行交互。
    // 由此可以得出混合使用泛型和数组是比较危险的，因为Java的编译器禁止了这样的使用方法，一旦使用，将会报编译错误。
    /* List<Object> objList = new List<Long>(); */

    // public void test() {
    // // 这里我们先假设该语句可以通过编译
    // List<String>[] stringLists = new List<String>[1];
    //
    // // 该语句是正常的，intList中将仅包含值为42的一个整型元素
    // List<Integer> intList = Arrays.asList(42);
    //
    // // 该语句也是合法的，因为数组支持协变
    // Object[] objects = stringLists;
    // // 由于泛型对象在运行时是擦除对象类型信息的，擦除后intList将变为List类型
    // // 而objects是Object类型的数组，List本身也是Object的子类，因此下面的语句合法。
    // objects[0] = intList;
    // // 下面的语句将会抛出ClassCastException异常。很显然stringLists[0]是List<Integer>对象。
    // // [List0,List2]
    // String s = stringLists[0].get(0);
    // }
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    public static <E> Set<E> unionRight(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
        public Object apply(Object arg) {
            return arg;
        }
    };

    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction() {
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }

    public static void main(String[] args) {

        String a = "dfs";
        assert (a != null);
        System.out.println("yes");

        String[] strings = {"jute","hemp","nylon"};
        UnaryFunction<String> sameString = identityFunction();
        for (String s : strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = {1,2.0,3L};
        UnaryFunction<Number> sameNumber = identityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }
}
