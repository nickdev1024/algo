package pkg01;

import util.Util;

/**
 * @author nick
 */
public class Q05LeftMostGreaterEqual {

    public int binaryLeftmost(int[] sorted, int target) {
        if (sorted == null || sorted.length <= 0) {
            return -1;
        }
        int len = sorted.length;
        int left = 0;
        int right = len - 1;
        int mid, val;
        int leftmost = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            val = sorted[mid];
            if (val >= target) {
                leftmost = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return leftmost;
    }

    public int linearLeftmost(int[] sorted, int target) {
        if (sorted == null || sorted.length <= 0) {
            return -1;
        }
        int len = sorted.length;
        for (int i = 0; i < len; i++) {
            if (sorted[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    private void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        doSort(arr, 0, len - 1);
    }

    private void doSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        doSort(arr, left, mid);
        doSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int len = right - left + 1;
        int[] help = new int[len];
        int i = 0, p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < len; i++) {
            arr[left + i] = help[i];
        }
    }

    static public void main(String... args) {
        int seed = 300;
        int[] arr;
        int target, leftmost1, leftmost2;
        Util util = new Util();

        int million = 1_000_000;

        long start = util.getCurTime();
        System.out.println("test start ...");
        for (int i = 0; i < million; i++) {
            Q05LeftMostGreaterEqual left = new Q05LeftMostGreaterEqual();
            arr = util.generateRandArray(seed);
            target = (int) (Math.random() * seed);
            left.mergeSort(arr);
            leftmost1 = left.binaryLeftmost(arr, target);
            leftmost2 = left.linearLeftmost(arr, target);

            if (leftmost1 != leftmost2) {
                System.out.println("test fail ...");
                return;
            }
        }
        long end = util.getCurTime();
        System.out.printf("test pass ... time taken : %f sec", (end - start) / 1000f);
    }
}