package programmers;

import java.util.stream.IntStream;

/**
 * 야근 지수
 * https://programmers.co.kr/learn/courses/30/lessons/12927
 */
public class Solution12927 {
    public static long solution(int n, int[] works) {
        int[] result = new int[works.length];
        int total = IntStream.of(works).sum() - n;
        int time = total;

        if (time <= 0) {
            return 0;
        }

        for (int i = 0; i < works.length; i++) {
            result[i] = Math.min(works[i], total / works.length);
            time -= result[i];
        }

        for (int i = 0; i < works.length; i++) {
            if (time <= 0) {
                break;
            }
            if (works[i] > result[i]) {
                result[i]++;
                time--;
            }
            if (i == works.length - 1) {
                i = -1;
            }
        }

        int sum = 0;
        for (int work : result) {
            sum += (work * work);
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4, 3, 3}));
    }
}
