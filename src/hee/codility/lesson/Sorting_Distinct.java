package hee.codility.lesson;

import java.util.HashSet;

public class Sorting_Distinct {
    public int solution(int[] A) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < A.length; i++)
            hashSet.add(A[i]);

        // System.out.println(hashSet.size());
        return hashSet.size();
    }
}
