package hee.codility.naverfin;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Solution1Test {

    private Solution1 solution;

    @Before
    public void setUp() {
        solution = new Solution1();
    }

    @Test
    public void test1() {
        // test1
//        int[] A = {3, 4, 3, 0, 2, 2, 3, 0, 0}; // 5
//        int[] A = {4, 2, 0}; // 0
        int[] A = {4, 4, 3, 0, 1, 0}; // 3

//        int[] A = {3, -1, -5, -9}; // 3
//        int[] A = {0, 1}; // 0
//        int[] A = {1, 1, 2, 5, 7}; // 0
//        int[] A = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0, -1}; // 8
//        int[] A = {-1, -1, -1}; // 1
        int result = solution.solution(A);

        assertThat(result, is(3));
    }
}
