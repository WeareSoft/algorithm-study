package hee.codility.lesson;

import java.util.Arrays;

public class CountingElements_PermCheck {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                // System.out.println(0);
                return 0;
            }
        }
        // System.out.println(1);
        return 1;
    }
}
