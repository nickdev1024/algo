package pkg01;

import util.Util;

/**
 * @author nick
 */
public class Q12SinglyLinkedList {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    int size;

    void setup(int[] arr) {
        if (arr == null) {
            return;
        }
        head = null;
        size = 0;
        for (int val : arr) {
            push(val);
        }
    }

    void push(int val) {
        Node node = new Node(val);
        ++size;
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    void print() {
        if (head == null) {
            return;
        }
        Node cur = head;
        System.out.print(cur.val);
        while (cur.next != null) {
            cur = cur.next;
            System.out.print(" -> " + cur.val);
        }
        System.out.println();
    }

    Node reverse() {
        if (head == null) {
            return null;
        }
        Node prev = null, next, cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return prev;
    }

    int[] reverseArray(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int len = arr.length;
        int[] reverse = new int[len];
        for (int i = len - 1; i >= 0; --i) {
            reverse[len - 1 - i] = arr[i];
        }
        return reverse;
    }

    boolean equal(int[] arr) {
        if (head == null && arr == null) {
            return true;
        }
        if (head == null && arr.length == 0) {
            return true;
        }
        int len = arr.length;
        if (size != len) {
            System.out.println("size: " + size + " len: " + len);
            return false;
        }
        Node cur = head;
        for (int val : arr) {
            if (cur.val != val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    static public void main(String... args) {
        int seed = 200;
        Util util = new Util();
        Q12SinglyLinkedList obj = new Q12SinglyLinkedList();
        int[] arr, reverse;

        int million = 1_000_000;

        long start = util.getCurTime();
        System.out.println("test start ...");
        for (int i = 0; i < million; i++) {
            arr = util.generateRandArray(seed);
            reverse = obj.reverseArray(arr);
            obj.setup(arr);

            if (!obj.equal(arr)) {
                util.printArray(arr);
                obj.print();
                System.out.println("equal fail ...");
                return;
            }

            obj.head = obj.reverse();
            if (!obj.equal(reverse)) {
                util.printArray(reverse);
                obj.print();
                System.out.println("reverse equal fail ...");
                return;
            }
        }
        long end = util.getCurTime();
        System.out.printf("test pass ... time taken : %f sec", (end - start) / 1000f);
    }
}