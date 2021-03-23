package pkg01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Util;

/**
 * @author nick
 */
class Q12SinglyLinkedListTest {

    int[] arr, reverse;

    @BeforeEach
    void setUp() {
        Util util = new Util();
        int seed = 250;
        arr = util.generateRandArray(seed);
        int len = arr.length;
        reverse = new int[len];
        for (int i = len - 1; i >= 0; --i) {
            reverse[len - 1 - i] = arr[i];
        }
    }

    @AfterEach
    void tearDown() {
        arr = null;
        reverse = null;
    }

    @Test
    void reverse() {
        Q12SinglyLinkedList obj = new Q12SinglyLinkedList();
        obj.setup(arr);
        Assertions.assertTrue(obj.equal(arr));
        obj.reverse();
        Assertions.assertTrue(obj.equal(reverse));
    }
}