package hee.codility.lesson;

import java.util.Arrays;

public class TimeComplexity_PermMissingElem {
    // [TIP] 빈 행렬일 때와 마지막 값 확인!!
    public int solution(int[] A) {
        if (A.length == 0) { // 빈 행렬이면 첫 번째 값 생각!!
            return 1;
        }

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return A[i] - 1;
            }
        }
        // 마지막까지 빠진 것이 없으면 마지막 값+1(N+1) 생각!!
        return A[A.length - 1] + 1;
    }
}
