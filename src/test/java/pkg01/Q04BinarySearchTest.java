package pkg01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Util;

/**
 * @author nick
 */
class Q04BinarySearchTest {

    int[] arr;
    int target;

    @BeforeEach
    void setUp() {
        int seed = 500;
        Util util = new Util();
        arr = util.generateRandArray(seed);
        target = (int) (Math.random() * seed);
    }

    @AfterEach
    void tearDown() {
        arr = null;
    }

    @Test
    void binarySearch() {
        Q04BinarySearch search = new Q04BinarySearch();
        search.quickSort(arr);
        boolean hit1, hit2;
        hit1 = search.binarySearch(arr, target);
        hit2 = search.linearSearch(arr, target);
        Assertions.assertEquals(hit1, hit2);
    }
}