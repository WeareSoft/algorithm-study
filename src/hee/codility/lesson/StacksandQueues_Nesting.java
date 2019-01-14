package hee.codility.lesson;

// https://app.codility.com/demo/results/trainingZ8M368-F9E/
public class StacksandQueues_Nesting {
    public int solution(String S) {
        if (S.isEmpty()) {
            return 1;
        }

        int sum = 0;
        for (char C : S.toCharArray()) {
            if (sum < 0) { // 음수가 될 수 없다.
                return 0;
            }
            if (C == '(') {
                sum++;
            } else {
                sum--;
            }
        }
        if (sum == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
