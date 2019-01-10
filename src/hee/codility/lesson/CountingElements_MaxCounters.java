package hee.codility.lesson;

public class CountingElements_MaxCounters {
    // [TIP] 시간 초과 주의!! 이중 반복문 쓰지 않도록 O(N + M)
    public int[] solution(int N, int[] A) {
        int[] C = new int[N];
        int max = 0;
        int tmpMax = 0;

        for (int i = 0; i < A.length; i++) {
            /* max counter */
            if (A[i] == N + 1) {
                // 임시 최댓값을 실제 최댓값으로 변경.
                max = tmpMax;
            }
            /* increase(X) */
            else {
                // 최댓값 적용
                if (C[A[i] - 1] < max) {
                    C[A[i] - 1] = max;
                }
                // 최댓값 적용 후 +1
                C[A[i] - 1]++;
                // increase(X)한 후의 값이 더 크면 임시 최댓값 변경.
                if (C[A[i] - 1] > tmpMax) {
                    tmpMax = C[A[i] - 1];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            // 최댓값 적용
            if (C[i] < max) {
                C[i] = max;
            }
        }
        return C;
    }
}
