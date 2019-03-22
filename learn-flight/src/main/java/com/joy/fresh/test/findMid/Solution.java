package com.joy.fresh.test.findMid;

/**
 * Created by jianyuanhao on 18-5-1.
 */
/**
 * Author: ������ Date: 2015-06-17 Time: 20:54 Declaration: All Rights Reserved !!!
 */
public class Solution {
    /**
     * <pre>
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity
     * should be O(log (m+n)).
     *
     * ��Ŀ���⣺
     * �����������飬�������������������λ����ʱ�临�Ӷ�ΪO(log(m+n))
     *
     * ���˼·��
     * �ݹ�������
     * </pre>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null) {
            nums1 = new int[0];
        }

        if (nums2 == null) {
            nums2 = new int[0];
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 < len2) {
            // ȷ����һ������ȵڶ������鳤�ȴ�
            return findMedianSortedArrays(nums2, nums1);
        }

        // �������С�����鳤��Ϊ0���ͷ���ǰһ���������λ��
        if (len2 == 0) {
            return (nums1[(len1 - 1) / 2] + nums1[len1 / 2]) / 2.0;
        }

        int lo = 0;
        int hi = len2 * 2;
        int mid1;
        int mid2;
        double l1;
        double l2;
        double r1;
        double r2;

        while (lo <= hi) {
            mid2 = (lo + hi) / 2;
            mid1 = len1 + len2 - mid2;

            l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];

            r1 = (mid1 == len1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            r2 = (mid2 == len2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

            if (l1 > r2) {
                lo = mid2 + 1;
            } else if (l2 > r1) {
                hi = mid2 - 1;
            } else {
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] p1 = { 2, 3, 4, 5 };
        int[] p2 = { 3, 5, 6 };
        System.out.println(Solution.findMedianSortedArrays(p1, p2));
    }
}
