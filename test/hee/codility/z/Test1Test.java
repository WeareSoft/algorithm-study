package hee.codility.z;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Test1Test {
    private Test1 solution;

    @Before
    public void setUp() {
        solution = new Test1();
    }

    @Test
    public void test1() {
        int[] A = {1, -1};
        int result = solution.solution(A);

        assertThat(result, is(2));
    }

    @Test
    public void test2() {
        int[] A = {1};
        int result = solution.solution(A);

        assertEquals(1, result);
    }

    @Test
    public void test3() {
        int[] A = {1, 4, -1, 3, 2};
        int result = solution.solution(A);

        assertThat(result, is(4));
    }
}
