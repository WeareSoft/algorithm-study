package hee.codility.naverfin;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution1 {
    public int solution(int[] A) {
        Set<Integer> integers = Arrays.stream(A)
                .boxed()
                .collect(Collectors.toSet());

        int result = 0;
        for (int value : A) {
            if (integers.contains(value + 1)) {
                result++;
            }
        }
        return result;
    }
}
