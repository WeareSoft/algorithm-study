package programmers;

/**
 * 점프와 순간 이동
 * https://programmers.co.kr/learn/courses/30/lessons/12980
 */
public class Solution12980 {
    public static void main(String[] args) {
        System.out.println(new Solution12980().solution(5));
        System.out.println(new Solution12980().solution(6));
        System.out.println(new Solution12980().solution(5000));
    }

    public int solution(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                cnt++;
                n--;
            }
            n /= 2;
        }
        return cnt;
    }
}