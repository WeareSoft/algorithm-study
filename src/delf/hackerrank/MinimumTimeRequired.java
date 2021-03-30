package hackerrank;

import java.util.Arrays;

/**
 * Minimum Time Required
 * https://www.hackerrank.com/challenges/minimum-time-required/problem
 */
public class MinimumTimeRequired {

    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);
        return binarySearchRecursive(machines, goal, 1, machines[machines.length - 1] * goal);
    }

    static long binarySearchRecursive(long[] machines, long goal, long min, long max) {
        if (min == max) {
            return min;
        }

        long mid = (min + max) / 2;
        long produce = 0;

        for (long machine : machines) {
            produce += Math.floor((double) (mid / machine));
        }

        if (produce < goal) {
            return binarySearchRecursive(machines, goal, mid + 1, max);
        } else {
            return binarySearchRecursive(machines, goal, min, mid);
        }
    }
}
