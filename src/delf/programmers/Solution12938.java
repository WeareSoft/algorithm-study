package programmers;

import java.util.Arrays;

/**
 * 최고의 집합
 * https://programmers.co.kr/learn/courses/30/lessons/12938
 */
public class Solution12938 {
    public int[] solution(int n, int s) {
        int div = s / n;
        if (div == 0) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        Arrays.fill(answer, div);

        int rest = s % n;
        for (int i = 0; i < rest; i++) {
            answer[n - 1 - i]++;
        }

        return answer;
    }
}
