package hee.codility.lesson;

public class TimeComplexity_TapeEquilibrium {
    public int solution(int[] A) {
        int totalRight = 0;
        int totalLeft = 0;
        for (int i = 0; i < A.length; i++) { // 시간복잡도 생각!! 이중 반복문: O(N^2)
            totalRight += A[i];
        }

        int minDiff = Integer.MAX_VALUE;
        for (int P = 1; P < A.length; P++) {
            totalLeft += A[P - 1];
            totalRight -= A[P - 1];

            int diff = Math.abs(totalLeft - totalRight);
            if (minDiff > diff) {
                minDiff = diff;
            }
        }
        // System.out.println(minDiff);
        return minDiff;
    }
}
