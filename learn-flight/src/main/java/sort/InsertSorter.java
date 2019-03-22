package sort;

import java.util.Arrays;

/**
 * Created by jianyuanhao on 18-12-8.
 */
public class InsertSorter {
    public int[] sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            int elem = arr[i];
            int j = i - 1;
            while (j >= 0 && elem < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = elem;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 3, 4, 56, 7, 24, 2, 1 };
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(new InsertSorter().sort(a)));

    }
}
