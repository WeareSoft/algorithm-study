package hee.codility.zom;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Test3Test {
    private Test3 solution;

    @Before
    public void setUp() {
        solution = new Test3();
    }

    @Test
    public void test1() {
        int[] A = {5, 4, 4, 5, 0, 12}; // 4
        int result = solution.solution(A);

        assertThat(result, is(4));
    }

    @Test
    public void test2() {
        int[] A = {4, 4}; // 2
        int result = solution.solution(A);

        assertThat(result, is(2));
    }

    @Test
    public void test3() {
        int[] A = {5, 4, 4, 5, 5, 0, 0, 0, 5}; // 6
        int result = solution.solution(A);

        assertThat(result, is(6));
    }

    @Test
    public void test4() {
        int[] A = {5, 5, 4, 5, 5, 4, 3, 3, 3, 3, 4, 4}; // 7
        int result = solution.solution(A);

        assertThat(result, is(7));
    }

    @Test
    public void test5() {
        int[] A = {5, 5, 5, 5, 5, 4, 4, 3, 3, 3, 3, 4, 4}; // 8
        int result = solution.solution(A);

        assertThat(result, is(8));
    }

    @Test
    public void test6() {
        int[] A = {5}; // 1
        int result = solution.solution(A);

        assertThat(result, is(1));
    }

    @Test
    public void test7() {
        int[] A = {}; // 0
        int result = solution.solution(A);

        assertThat(result, is(0));
    }

    @Test
    public void test8() {
        int[] A = {5, 4}; // 2
        int result = solution.solution(A);

        assertThat(result, is(2));
    }

}
