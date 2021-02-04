package programmers.skillcheck;

import java.util.Arrays;

public class SkillCheck0201 {
    public static void main(String[] args) {

    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int weight = people[left] + people[right];
            if (weight <= limit) {
                left++;
            }
            right--;
            answer++;
        }
        return answer;
    }
}
