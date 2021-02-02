package programmers;

/**
 * 예상 대진표
 * https://programmers.co.kr/learn/courses/30/lessons/12985
 */
public class Solution12985 {
    public static void main(String[] args) {
        System.out.println(">>" + new Solution12985().solution(8, 1, 2)); // 1
        System.out.println(">>" + new Solution12985().solution(8, 2, 3)); // 2
        System.out.println(">>" + new Solution12985().solution(8, 4, 7)); // 3
    }

    public int solution(int n, int a, int b) {
        int answer = 0;
        do {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        } while (Math.abs(a - b) > 0);
        return answer;
    }
}
