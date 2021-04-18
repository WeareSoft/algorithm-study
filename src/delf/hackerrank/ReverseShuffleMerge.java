package hackerrank;

import java.util.Arrays;
import java.util.Stack;

/**
 * Reverse Shuffle Merge
 * https://www.hackerrank.com/challenges/reverse-shuffle-merge/problem
 */
public class ReverseShuffleMerge {
    public static void main(String[] args) {
        System.out.println(reverseShuffleMerge2("zbayc"));
    }

    static String reverseShuffleMerge2(final String input) {
        char[] reversed = new StringBuilder(input).reverse().toString().toCharArray();
        char[] sorted = input.toCharArray();
        Arrays.sort(sorted);

        StringBuilder result = new StringBuilder();

        int revIdx = 0, srtIdx = 0;
        while (revIdx < reversed.length && srtIdx < sorted.length) {
            char r = reversed[revIdx];
            char s = sorted[srtIdx];

            if (r > s) {
                result.append(s);
                srtIdx++;
            } else {
                result.append(r);
                revIdx++;
            }
        }

        return result.toString();
    }
}
