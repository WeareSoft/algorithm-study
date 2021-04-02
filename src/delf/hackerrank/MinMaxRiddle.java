package hackerrank;

import java.util.*;

/**
 * Min Max Riddle
 * https://www.hackerrank.com/challenges/min-max-riddle/problem
 */
public class MinMaxRiddle {
    static long[] riddle(int[] arr) {
        int[] lefts = leftWinSize(arr);
        int[] rights = rightWinSize(arr);

        SortedMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], Math.max(map.getOrDefault(arr[i], -1), lefts[i] + rights[i] + 1));
        }

        Iterator<Integer> iter = map.keySet().iterator();
        int number = iter.next();
        long[] result = new long[arr.length];

        for (int i = 0; i < result.length; i++) {
            while (map.get(number) <= i) {
                number = iter.next();
            }
            result[i] = number;
        }
        return result;
    }

    static int[] leftWinSize(int[] arr) {
        int[] lefts = new int[arr.length];
        Stack<Integer> indices = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!indices.isEmpty() && arr[i] <= arr[indices.peek()]) {
                indices.pop();
            }
            lefts[i] = i - (indices.isEmpty() ? 0 : indices.peek() + 1);
            indices.push(i);
        }

        return lefts;
    }

    static int[] rightWinSize(int[] arr) {
        int[] rights = new int[arr.length];
        Stack<Integer> indices = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!indices.isEmpty() && arr[i] <= arr[indices.peek()]) {
                indices.pop();
            }

            rights[i] = (indices.isEmpty() ? arr.length : indices.peek()) - (i + 1);
            indices.push(i);
        }
        return rights;
    }
}
