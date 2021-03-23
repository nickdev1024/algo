package pkg01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Util;

import java.util.Arrays;

/**
 * @author nick
 */
class Q05LeftMostGreaterEqualTest {

    int[] arr;
    int target;

    @BeforeEach
    void setUp() {
        int seed = 300;
        Util util = new Util();
        arr = util.generateRandArray(seed);
        Arrays.sort(arr);
        target = (int) (Math.random() * seed);
    }

    @AfterEach
    void tearDown() {
        arr = null;
    }

    @Test
    void leftmost() {
        Q05LeftMostGreaterEqual obj = new Q05LeftMostGreaterEqual();
        int left1, left2;
        left1 = obj.binaryLeftmost(arr, target);
        left2 = obj.linearLeftmost(arr, target);
        Assertions.assertEquals(left1, left2);
    }
}