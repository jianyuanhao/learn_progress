package com.joy.fresh.model;

import java.util.Arrays;

/**
 * Created by jianyuanhao on 18-4-1.
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 即elements = new E[DEFAULT_INITIAL_CAPACITY]
    // 语句不能直接实例化泛型该类型的对象
//    public Stack() {
//        elements = new E[DEFAULT_INITIAL_CAPACITY];
//    }
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[])new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new RuntimeException();
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
