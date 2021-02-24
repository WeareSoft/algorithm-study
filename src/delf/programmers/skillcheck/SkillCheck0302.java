package programmers.skillcheck;

import java.util.Arrays;

public class SkillCheck0302 {
    public int[] solution(int n, int s) {
        int div = s / n;
        int rest = s % n;

        if (div == 0) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        Arrays.fill(answer, div);

        if (rest == 0) {
            return answer;
        }

        int cursor = 0;
        for (int i = 0; i < rest; i++, cursor %= n) {
            answer[cursor++]++;
        }
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SkillCheck0302().solution(2, 9)));

    }
}
