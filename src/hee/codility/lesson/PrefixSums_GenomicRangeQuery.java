package hee.codility.lesson;

public class PrefixSums_GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        /* 62% O(N + M) */
//        int M = P.length;
//        int[] results = new int[M];
//        for (int i = 0; i < M; i++) {
//            int start = P[i];
//            int end = Q[i];
//
//            String string = S.substring(start, end + 1);
//            if (string.contains("A")) {
//                results[i] = 1;
//            } else if (string.contains("C")) {
//                results[i] = 2;
//            } else if (string.contains("G")) {
//                results[i] = 3;
//            } else if (string.contains("T")){
//                results[i] = 4;
//            }
//        }
//        return results;

        /* 100% O(N + M) */
        int N = S.length();
        int[][] count = new int[N + 1][4];
        for (int i = 0; i < N; i++) {
            // 변화를 기록하기 위해 이전의 내용을 그대로 가져온다.
            for (int j = 0; j < 4; j++) {
                count[i + 1][j] = count[i][j];
            }
            // 해당 문자가 추가(변화 기록)
            switch (S.charAt(i)) {
                case 'A':
                    count[i + 1][0]++;
                    break;
                case 'C':
                    count[i + 1][1]++;
                    break;
                case 'G':
                    count[i + 1][2]++;
                    break;
                case 'T':
                    count[i + 1][3]++;
                    break;
            }
        }

        int M = P.length;
        int[] results = new int[M];
        for (int i = 0; i < M; i++) {
            int start = P[i];
            int end = Q[i];

            // 범위 내에서 해당 문자(ACGT 순)의 수에 변화가 있으면 그 문자가 나타난 것.
            for (int j = 0; j < 4; j++) {
                if (count[end + 1][j] - count[start][j] > 0) {
                    results[i] = j + 1; // 문자의 값을 결과에 추가
                    break;
                }
            }
        }
        return results;
    }
}
