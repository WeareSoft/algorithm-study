package programmers;

public class Solution62048 {
    public static void main(String[] args) {
        System.out.println(new Solution62048().solution(8, 12));
    }

    public long solution(int w, int h) {
        return ((long) w * (long) h) - ((long) w + (long) h - getGcd(w, h));
    }

    private long getGcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }
}
