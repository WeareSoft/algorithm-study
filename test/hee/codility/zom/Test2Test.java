package hee.codility.zom;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Test2Test {
    private Test2 solution;

    @Before
    public void setUp() {
        solution = new Test2();
    }

    @Test
    public void test1() {
        int[] A = {1, 3, 5, 7, 9}; // 6
//        int[] A = {7, 7, 7, 7}; // 3
//        int[] A = {3, -1, -5, -9}; // 3
//        int[] A = {0, 1}; // 0
//        int[] A = {1, 1, 2, 5, 7}; // 0
//        int[] A = {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0, -1}; // 8
//        int[] A = {-1, -1, -1}; // 1
        int result = solution.solution(A);

        assertThat(result, is(6));
    }

}
