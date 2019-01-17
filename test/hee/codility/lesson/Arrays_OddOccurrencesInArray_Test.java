package hee.codility.lesson;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Arrays_OddOccurrencesInArray_Test {
    private Arrays_OddOccurrencesInArray solution;

    @Before
    public void setUp() {
        solution = new Arrays_OddOccurrencesInArray();
    }

    @Test
    public void test1() {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        int result = solution.solution(A);

        assertEquals(7, result);
    }

    @Test
    public void test2() {
        int[] A = {1};
        int result = solution.solution(A);

        assertThat(result, is(1));
    }
}
