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
class Q03InsertionSortTest {

    int[] arr1, arr2;

    @BeforeEach
    void setUp() {
        int seed = 300;
        Util util = new Util();
        arr1 = util.generateRandArray(seed);
        arr2 = util.copyArray(arr1);
    }

    @AfterEach
    void tearDown() {
        arr1 = null;
        arr2 = null;
    }

    @Test
    void insertSort() {
        Q03InsertionSort sort = new Q03InsertionSort();
        sort.insertSort(arr1);
        Arrays.sort(arr2);
        int len = arr1.length;
        for (int i = 0; i < len; i++) {
            Assertions.assertEquals(arr1[i], arr2[i]);
        }
    }
}