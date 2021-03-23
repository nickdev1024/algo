package pkg01;

import util.Util;

/**
 * @author nick
 */
public class Q03InsertionSort {

    public void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        int cur;
        for (int i = 1; i < len; i++) {
            cur = i;
            while (cur - 1 >= 0 && arr[cur - 1] > arr[cur]) {
                Util.swap(arr, cur, cur-- - 1);
            }
        }
    }
}