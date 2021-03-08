package programmers;

import java.util.Arrays;

/**
 * 입국 심사
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 */
public class Solution43238 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 1;
        long right = times[times.length - 1] * (long) n;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (long time : times) {
                sum += (mid / time);
            }

            if (sum < n) {
                left = mid + 1;
            } else {
                if (mid <= answer) {
                    answer = mid;
                }
                right = mid - 1;
            }
        }
        return answer;
    }
}
