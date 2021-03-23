package pkg01;

import util.Util;

/**
 * Binary search: check the existence of the target, return true if found
 *
 * @author nick
 */
public class Q04BinarySearch {

    public boolean binarySearch(int[] sorted, int target) {
        if (sorted == null || sorted.length <= 0) {
            return false;
        }
        int left = 0;
        int right = sorted.length - 1;
        int mid, val;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            val = sorted[mid];
            if (val == target) {
                return true;
            } else if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return sorted[left] == target;
    }

    public boolean linearSearch(int[] sorted, int target) {
        if (sorted == null || sorted.length <= 0) {
            return false;
        }
        int len = sorted.length;
        for (int i = 0; i < len; i++) {
            if (sorted[i] == target) {
                return true;
            }
        }
        return false;
    }

    public void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        doSort(arr, left, right);
    }

    private void doSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] equals = partition(arr, left, right);
        doSort(arr, left, equals[0] - 1);
        doSort(arr, equals[1] + 1, right);
    }

    private int[] partition(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        if (left == right) {
            return new int[]{left, right};
        }
        int len = right - left + 1;
        int index = (int) (Math.random() * len) + left;
        int pivot = arr[index];
        Util.swap(arr, index, right);
        int less = left - 1;
        int more = right;
        for (int i = left; i < more; i++) {
            if (arr[i] > pivot) {
                Util.swap(arr, i--, --more);
            } else if (arr[i] < pivot) {
                Util.swap(arr, i, ++less);
            }
        }
        Util.swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    static public void main(String... args) {
        int seed = 300;
        int[] arr;
        int target;
        boolean hit1, hit2;
        Util util = new Util();
        Q04BinarySearch search = new Q04BinarySearch();
        int million = 1_000_000;

        System.out.println("test start ...");
        long start = util.getCurTime();
        for (int i = 0; i < million; i++) {
            arr = util.generateRandArray(seed);
            target = (int) (Math.random() * seed);
            search.quickSort(arr);
            hit1 = search.binarySearch(arr, target);
            hit2 = search.linearSearch(arr, target);
            if (hit1 != hit2) {
                System.out.println("test fail ...");
                return;
            }
        }
        long end = util.getCurTime();
        System.out.printf("test pass ... time taken : %f sec", (end - start) / 1000f);
    }
}