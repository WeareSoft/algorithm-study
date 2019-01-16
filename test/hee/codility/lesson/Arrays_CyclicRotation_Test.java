package hee.codility.lesson;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Arrays_CyclicRotation_Test {
    private Arrays_CyclicRotation solution;

    @Before
    public void setUp() {
        solution = new Arrays_CyclicRotation();
    }

    @Test
    public void test1() {
        int[] A = {3, 8, 9, 7, 6};
        int[] result = solution.solution(A, 3);

        int[] ans = {9, 7, 6, 3, 8};
        assertTrue(Arrays.equals(result, ans));
    }

    @Test
    public void test2() {
        int[] A = {};
        int[] result = solution.solution(A, 0);

        assertThat(result, is(new int[]{}));
    }

    @Test
    public void test3() {
        int[] A = {1, 2, 3, 4};
        int[] result = solution.solution(A, 100);

        assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }
}
