package com.joy.fresh.test;

import com.google.common.collect.Lists;

/**
 * Created by jianyuanhao on 18-4-20.
 */
public class LeeCode {

    public static int removeDuplicates(int[] nums) {
        int size = nums.length;
        int finalSize = 0;
        if (size == 0) {
            return finalSize;
        }
        int index = 0;
        int curIndex = 0;
        while (curIndex < size) {
            while (curIndex + 1 < size && nums[curIndex] == nums[curIndex + 1]) {
                curIndex++;
            }
            finalSize++;
            nums[index++] = nums[curIndex++];
        }
        return finalSize;
    }
}
