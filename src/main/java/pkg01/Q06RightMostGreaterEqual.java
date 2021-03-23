package pkg01;

import util.Util;

/**
 * @author nick
 */
public class Q06RightMostGreaterEqual {

    static private class Heap {
        int[] heap;
        int capacity;
        int size;

        Heap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            heap = new int[capacity];
        }

        boolean empty() {
            return size == 0;
        }

        boolean full() {
            return size == capacity;
        }

        void push(int val) {
            if (full()) {
                System.err.println("heap is full");
                return;
            }
            heap[size] = val;
            heapInsert(heap, size++);
        }

        void push(int val, int index) {
            if (full()) {
                System.err.println("heap is full");
                return;
            }
            heap[index] = val;
            ++size;
        }

        int pop() {
            if (empty()) {
                throw new RuntimeException("heap is empty");
            }
            int ans = heap[0];
            swap(heap, 0, --size);
            heapify(heap, 0, size);
            return ans;
        }

        void heapInsert(int[] heap, int index) {
            int root;
            while ((root = ((index - 1) >> 1)) >= 0 && heap[index] > heap[root]) {
                swap(heap, root, index);
                index = root;
            }
        }

        void heapify(int[] heap, int root, int size) {
            int left, right, largest;
            while ((left = (root << 1) + 1) < size) {
                largest = (right = left + 1) < size && heap[right] > heap[left] ? right : left;
                largest = heap[root] > heap[largest] ? root : largest;
                if (largest == root) {
                    break;
                }
                swap(heap, largest, root);
                root = largest;
            }
        }

        private void swap(int[] heap, int i, int j) {
            if (i == j || heap == null || heap.length <= 1) {
                return;
            }
            heap[i] ^= heap[j];
            heap[j] ^= heap[i];
            heap[i] ^= heap[j];
        }
    }

    private void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        Heap heap = new Heap(len);
//        for (int val : arr) {
//            heap.push(val);
//        }
        for (int i = len - 1; i >= 0; --i) {
            heap.push(arr[i], i);
            heap.heapify(heap.heap, i, len);
        }
        for (int i = len - 1; i > -0; --i) {
            arr[i] = heap.pop();
        }
    }

    public int binaryRightMost(int[] arr, int target) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid, val, rightmost = -1;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            val = arr[mid];
            if (val >= target) {
                rightmost = mid;
            }
            left = mid + 1;
        }
        return rightmost;
    }

    public int linearRightMost(int[] arr, int target) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    private boolean equal(int[] arr1, int[] arr2) {
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
            if (arr1[len - 1 - i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    static public void main(String... args) {
        int seed = 233;
        int[] arr;
        int target, right1, right2;
        Util util = new Util();
        Q06RightMostGreaterEqual obj = new Q06RightMostGreaterEqual();

        int million = 1_000_000;
        long start = util.getCurTime();
        System.out.println("test start ...");
        for (int i = 0; i < million; i++) {
            arr = util.generateRandArray(seed);
            obj.heapSort(arr);
            target = (int) (Math.random() * seed);
            right1 = obj.binaryRightMost(arr, target);
            right2 = obj.linearRightMost(arr, target);

            if (right1 != right2) {
                util.printArray(arr);
                System.out.println("target: " + target + " right: " + right1 + " right2: " + right2);
                System.out.println("test fail ...");
                return;
            }
        }
        long end = util.getCurTime();
        System.out.printf("test pass ... time taken : %f sec", (end - start) / 1000f);
    }
}