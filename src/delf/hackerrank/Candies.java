package hackerrank;

/**
 * Abbreviation
 * https://www.hackerrank.com/challenges/abbreviation/problem
 */
public class Candies {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 4, 2, 6, 1, 7, 8, 9, 2, 1};
        System.out.println(candies(arr.length, arr));
    }

    static long candies(int n, int[] arr) {

        int[] up = new int[arr.length];
        int[] down = new int[arr.length];

        up[0] = 1;
        down[arr.length - 1] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                up[i] = up[i - 1] + 1;
            } else {
                up[i] = 1;
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            int t = (arr[i + 1] < arr[i]) ? (down[i + 1] + 1) : 1;
            down[i] = Math.max(down[i], t);

            if (arr[i + 1] < arr[i]) {
                down[i] = Math.max(down[i], down[i + 1] + 1);
            } else {
                down[i] = 1;
            }
        }

        long answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer += Math.max(up[i], down[i]);
        }

        return answer;
    }
}
