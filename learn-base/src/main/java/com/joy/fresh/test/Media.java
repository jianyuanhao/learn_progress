package com.joy.fresh.test;

/**
 * Created by jianyuanhao on 18-5-1.
 */
import java.util.PriorityQueue;

/**
 * Created by jianyuanhao on 18-5-1.
 */
public class Media {
    public static double median(int[] array) {
        int heapSize = array.length / 2 + 1;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(heapSize);
        for (int i = 0; i < heapSize; i++) {
            heap.add(array[i]);
        }
        for (int i = heapSize; i < array.length; i++) {
            if (heap.peek() < array[i]) {
                heap.poll();
                heap.add(array[i]);
            }
        }
        if (array.length % 2 == 1) {
            return (double) heap.peek();
        } else {
            return (double) (heap.poll() + heap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] array = { 2, 3, 1, 4, 7, 5, 6 };
        System.out.println(Media.median(array));
    }
}