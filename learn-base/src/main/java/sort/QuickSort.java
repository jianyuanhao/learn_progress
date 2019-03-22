package sort;

/**
 * 最坏时间复杂度:O(n*n):T(n)=T(n-1)+O(n)=T(n-2)+O(n)+O(n)=...=O(n^2) 平均时间复杂度:O(nlogn)=>主定理 T(n)=2*T(n/2) Created by
 * jianyuanhao on 18-12-11.
 */
public class QuickSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        sortHelp(arr, 0, arr.length - 1);
    }

    public void sortThreeWay(int[] arr, int start, int end) {
        if (end - start <= 3 - 1) {
            insertSort(arr, start, end);
            return;
        }

        int pivot = arr[start];
        int lt = start;
        int gt = end;
        int i = start + 1;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt, i);
                lt++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
            sortThreeWay(arr, start, lt - 1);
            sortThreeWay(arr, gt + 1, end);
        }

    }

    private void sortHelp(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        // 优化－数组划分比较小时用插入排序
        if (end - start <= 3 - 1) {
            insertSort(arr, start, end);
            return;
        }
        // 三平均分区法
        int median = meidanOf3Num(arr, start, start + (end - start) / 2, end);
        // int index = partition(arr, start, end);
        swap(arr, start, median);
        int index = partition(arr, start, end);

        sortHelp(arr, start, index - 1);
        sortHelp(arr, index + 1, end);
    }

    private void insertSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        for (int i = start + 1; i <= end; i++) {
            int elem = arr[i];

        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        for (int j = start + 1; j <= end; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, start, i - 1);
        return i - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int partition2(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start < end) {
            while (start < end && arr[end] > pivot) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= pivot) {
                start++;
            }
            arr[end] = arr[start];
        }
        return pivot;
    }

    private int meidanOf3Num(int[] arr, int lo, int center, int hi) {
        if (arr[lo] < arr[center]) {
            if (arr[center] < arr[hi]) {
                return center;
            } else {
                return arr[lo] < arr[hi] ? hi : lo;
            }
        } else {
            return arr[hi] > arr[lo] ? lo : hi;
        }
    }
}
