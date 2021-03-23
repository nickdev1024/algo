package pkg01;

import util.Util;

import java.util.Arrays;

/**
 * @author nick
 */
public class Q01SelectionSort {

    public void selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        int min;
        for (int i = 0; i < len - 1; i++) {
            min = i;
            for (int j = i + 1; j < len; j++) {
                min = arr[min] > arr[j] ? j : min;
            }
            if (min != i) {
                Util.swap(arr, i, min);
            }
        }
    }

    static public void main(String... args) {
        int seed = 300;
        int[] arr1, arr2;
        Q01SelectionSort select = new Q01SelectionSort();
        Util util = new Util();
        int test = 1_000_000;

        System.out.println("test start ...");
        long start = util.getCurTime();
        for (int i = 0; i < test; i++) {
            arr1 = util.generateRandArray(seed);
            arr2 = util.copyArray(arr1);
            Arrays.sort(arr1);
            select.selectSort(arr2);
            if (!util.equal(arr1, arr2)) {
                System.out.println("test fail ...");
                return;
            }
        }
        long end = util.getCurTime();
        System.out.printf("test pass ... time taken : %f sec", (end - start) / 1000f);
    }
}