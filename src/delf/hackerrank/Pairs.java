package hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Pairs
 * https://www.hackerrank.com/challenges/pairs/problem
 */
public class Pairs {
    static int pairs(int k, Integer[] arr) {
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        return (int) Arrays.stream(arr).filter(v -> set.contains(v - k)).count();
    }
}
