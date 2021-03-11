package programmers;

/**
 * 야근 지수
 * https://programmers.co.kr/learn/courses/30/lessons/68646
 */
public class Solution68646 {
    public int solution(int[] a) {
        if (a.length == 1) {
            return 1;
        }

        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];

        int tmpMin = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            tmpMin = Math.min(a[i], tmpMin);
            leftMin[i] = tmpMin;
        }

        tmpMin = Integer.MAX_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            tmpMin = Math.min(a[i], tmpMin);
            rightMin[i] = tmpMin;
        }

        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            if (leftMin[i] < a[i] && rightMin[i] < a[i]) {
                continue;
            }
            answer++;
        }
        return answer;
    }
}
