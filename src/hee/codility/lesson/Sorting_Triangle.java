package hee.codility.lesson;

import java.util.Arrays;

public class Sorting_Triangle {
    // [TIP] int 범위 주의!! 2,147,483,647 + 2,147,483,647 = -2, Long.valueOf(int); 이용
    public int solution(int[] A) {
        if (A.length == 0) { // 빈 문자열
            return 0;
        }

        Arrays.sort(A);

        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < 0)
                break;

            long Ai = Long.valueOf(A[i]);
            long sum = Long.valueOf(A[i - 1]) + Long.valueOf(A[i - 2]);
            if (Ai < sum) {
                return 1;
            }

        }
        return 0;
    }
}
