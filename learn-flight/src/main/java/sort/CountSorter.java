package sort;

/**
 * Created by jianyuanhao on 18-12-11.
 */
public class CountSorter {
    public void sort(int arr[]) {
        int max = findMax(arr);
        int[] count = new int[max + 1];
        count(arr, count);
        rebuild(arr, count);
    }

    private int findMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;

    }

    private void count(int arr[], int[] c) {
        for (int i : arr) {
            c[i]++;
        }
    }

    private void rebuild(int[] arr, int[] count) {
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[index++] = i;

            }
        }
    }
    //totalCount[i]：到元素i为止，一共有多少个元素
    private void rebuildV2(int[] arr,int[] totalCount)
    {
        int[] sortedArr=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)

        {
            sortedArr[totalCount[arr[i]]-1]=arr[i];
            
        }
    }
}
