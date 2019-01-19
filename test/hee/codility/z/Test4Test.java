package hee.codility.z;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Test4Test {
    private Test4 solution;

    @Before
    public void setUp() {
        solution = new Test4();
    }

    @Test
    public void test1() {
        int[] A = {1, 3, -1}; // 6
        int result = solution.solution(A);

        assertThat(result, is(6));
    }

    @Test
    public void test2() {
        int[] A = {-1000000000, 1}; // 2
        int result = solution.solution(A);

        assertThat(result, is(2));
    }

    @Test
    public void test3() {
        int[] A = {1}; // 2
        int result = solution.solution(A);

        assertThat(result, is(2));
    }

    @Test
    public void test4() {
        int[] A = {-8, 4, 0, 5, -3, 6}; // 14
//        int[] A = {-8, 6, 0, 5, -3, 6};
//        int[] A = {-8, -8, -8, -8, -8};
//        int[] A = {6, 6, 5, 6, 6};
//        int[] A = {-8, 6, 0, 6, -3, 6};
        int result = solution.solution(A);

        assertThat(result, is(14));
    }

}
