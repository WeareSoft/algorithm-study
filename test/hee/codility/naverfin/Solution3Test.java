package hee.codility.naverfin;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Solution3Test {

    private Solution3 solution;

    @Before
    public void setUp() {
        solution = new Solution3();
    }

    @Test
    public void test3() {
        // test1
//        int[] A = new int[]{1, 1, 2, 4, 5};
//        int K = 5;

//        int[] A = new int[]{1, 1, 3};
//        int K = 2;

//        int[] A = new int[]{1, 1};
//        int K = 1;

//        int[] A = new int[]{1, 1, 2};
//        int K = 1;

        int[] A = new int[]{1, 2, 2, 2, 2, 3};
        int K = 2;

//        int max = 1000000000;
//        int[] A = new int[max];
//        for (int i = 0; i < max; i++) {
//            A[i] = i + 1;
//        }
//        int K = 1000000001;

        boolean result = solution.solution(A, K);

//        assertThat(result, is(true));
        assertThat(result, is(false));
    }
}
