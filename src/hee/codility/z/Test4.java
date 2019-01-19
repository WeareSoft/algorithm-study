package hee.codility.z;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public int solution(int[] A) {
        if (A.length == 1) {
//            System.out.println(A[0] + A[0]);
//            return;
            return A[0] + A[0];
        }

        int maxNum = A[0];
        for (int i = 1; i < A.length; i++)
            maxNum = Math.max(maxNum, A[i]);

        List<Integer> indexesOfMaxNum = new ArrayList<>();
        for (int i = 0; i < A.length; i++)
            if (maxNum <= A[i])
                indexesOfMaxNum.add(i); // 최댓값에 해당하는 인덱스 저장

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < indexesOfMaxNum.size(); i++) {
            int maxLength = A[0] + Math.abs(indexesOfMaxNum.get(i));

            for (int j = 1; j < A.length; j++) {
                int length = A[j] + Math.abs(indexesOfMaxNum.get(i) - j); // 자신의 값 + 해당 최댓값과의 거리
                maxLength = Math.max(maxLength, length);
            }
            max = Math.max(max, maxLength);
        }

//        System.out.println(max + maxNum);
        return max + maxNum;
    }
}
