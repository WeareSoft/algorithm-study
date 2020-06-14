package hee.codility.naverfin;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Solution2Test {

    private Solution2 solution;

    @Before
    public void setUp() {
        solution = new Solution2();
    }

    @Test
    public void test2() {
        // test1
//        String A = "abacdec";
        String A = "dddd";
        int result = solution.solution(A);

        assertThat(result, is(4));
    }
}
