package com.joy.fresh.test;

import java.util.Arrays;

/**
 * Created by jianyuanhao on 18-4-30.
 */
public class Main {
    public static void main(String[] args){
        int[] a = {1,3,2,1,4,5};
        printK(a,5);
    }
    public static void printK(int[] array,int k){
        if(array == null||array.length<=0){
            return ;
        }
        int length = array.length;
        Arrays.sort(array);
        int start = 0;
        int end = length - 1;

        while(start < end){
            while(array[start] == array[start+1]){
                start++;
            }
            while(array[end] == array[end-1]){
                end--;
            }
            if(array[start] + array[end] == k){
                System.out.println(start+" "+end);
                start ++;
            }
            if(array[start]+array[end] < k){
                start++;
            }
            if(array[start]+array[end] > k){
                end--;
            }
        }
        //System.out.println("can't find");
    }
}
