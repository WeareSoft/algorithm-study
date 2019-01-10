package hee.codility.lesson;

import java.util.Arrays;

public class CountingElements_MissingInteger {
    // [TIP] 문제 제대로 이해하기!! input ([97, 98, 99]) 생각!!
    public int solution(int[] A) {
        Arrays.sort(A);

        if (A[A.length - 1] <= 0) { // 양의 정수가 없는 경우
            return 1;
        }

        boolean[] B = new boolean[1000001];
        B[0] = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && !B[A[i]]) { // 1 ~
                B[A[i]] = true;
            }
        }
        for (int i = 0; i < B.length; i++) {
            if (!B[i]) {
                return i;
            }
        }
        return B.length;
    }
}
