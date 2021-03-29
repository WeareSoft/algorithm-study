package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Triple sum
 * https://www.hackerrank.com/challenges/triple-sum/problem
 */
public class TripleSum {
    static long triplets(int[] a, int[] b, int[] c) {
        List<Integer> listA = Arrays.stream(a).sorted().distinct().boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b).sorted().distinct().boxed().collect(Collectors.toList());
        List<Integer> listC = Arrays.stream(c).sorted().distinct().boxed().collect(Collectors.toList());

        long answer = 0;

        int countA = 0, countB = 0, countC = 0;
        while (countB < b.length) {
            while (countA < a.length && listA.get(countA) <= listB.get(countB)) {
                countA++;
            }
            while (countC < c.length && listC.get(countC) <= listB.get(countB)) {
                countC++;
            }
            answer += (long) countA * (long) countC;
            countB++;
        }
        return answer;
    }
}
