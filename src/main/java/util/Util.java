package util;

/**
 * @author nick
 */
public class Util {

    public int[] generateRandArray(int seed) {
        int len = (int) (Math.random() * seed);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * seed);
        }
        return arr;
    }

    public int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int len = arr.length;
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public boolean equal(int[] arr1, int[] arr2) {
        if (arr1 == arr2) {
            return true;
        }
        if (arr1 == null ^ arr2 == null) {
            return false;
        }
        int len = arr1.length;
        if (len != arr2.length) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    static public void swap(int[] arr, int i, int j) {
        if (i == j || arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        if (i < 0 || j < 0 || i >= len || j >= len) {
            return;
        }
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public long getCurTime() {
        return System.currentTimeMillis();
    }
}