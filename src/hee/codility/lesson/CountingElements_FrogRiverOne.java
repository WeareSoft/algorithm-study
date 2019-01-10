package hee.codility.lesson;

public class CountingElements_FrogRiverOne {
    // [TIP] 문제 제대로 이해하기!! input ([2, 2, 2, 2], 2) 생각!!
    public int solution(int X, int[] A) {
        boolean[] B = new boolean[X + 1];
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                if (!B[A[i]]) {
                    B[A[i]] = true;
                    cnt++;
                }
            }
            if (cnt == X) {
                return i; // i 시간에 X 위치 도달 가능
            }
        }
        return -1;
    }
}
