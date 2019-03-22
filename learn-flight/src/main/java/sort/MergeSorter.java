package sort;

import java.util.Arrays;

/**
 * Created by jianyuanhao on 18-12-8.
 */
public class MergeSorter {
    public int[] sort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return arr;
        }
        sortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    // 时间复杂度：T(n)=2*T(n/2)+O(n)+>O(nlogn)－主定理
    public void sortHelper(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sortHelper(arr, start, mid);
        sortHelper(arr, mid + 1, end);
        merge(arr, start, mid, mid + 1, end);
    }

    // O(m+n)两个指针 稳定 适合并行化
    // 空间复杂度O(n)=>原地
    //1 3 5 8
    //7 9 12 16
    private void merge(int[] arr, int s1, int e1, int s2, int e2) {
        int[] tmp = new int[e1 - s1 + e2 - s2 + 2];
        int i = s1, j = s2, k = 0;
        while (i <= e1 && j <= e2) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i];
                i++;
            } else {
                tmp[k++] = arr[j];
                j++;
            }
        }
        while (i < e1) {

            tmp[k++] = arr[i++];
        }
        while (j < e2) {
            tmp[k++] = arr[j++];
        }
        for (int l = 0; l < k; l++) {
            arr[l] = tmp[l];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] { 3, 4, 56, 7, 24, 2, 1, 4 };
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(new MergeSorter().sort(a)));

    }
}
