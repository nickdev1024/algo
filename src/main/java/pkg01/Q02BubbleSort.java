package pkg01;

import util.Util;

/**
 * @author nick
 */
public class Q02BubbleSort {

    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        for (int end = len - 1; end > 0; --end) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    Util.swap(arr, i, i + 1);
                }
            }
        }
    }
}