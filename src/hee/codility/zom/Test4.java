package hee.zom;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
//        int[] A = {1, 3, -1};
//        int[] A = {-1000000000, 1};
//        int[] A = {1};
//        int[] A = {-8, 4, 0, 5, -3, 6};
//        int[] A = {-8, 6, 0, 5, -3, 6};
//        int[] A = {-8,-8,-8,-8,-8};
//        int[] A = {6,6,5,6,6};
        int[] A = {-8, 6, 0, 6, -3, 6};

        if (A.length == 1) {
            System.out.println(A[0] + A[0]);
            return;
//            return A[0] + A[0];
        }

        int maxNum = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= maxNum)
                maxNum = A[i];
        }

        List<Integer> maxIndexes = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (maxNum <= A[i]) {
                maxIndexes.add(i); // 최댓값에 해당하는 인덱스 저장
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < maxIndexes.size(); i++) {
            int maxLength = A[0] + Math.abs(maxIndexes.get(i));

            for (int j = 1; j < A.length; j++) {
                int length = A[j] + Math.abs(maxIndexes.get(i) - j);
                maxLength = Math.max(maxLength, length);
            }

            if (max <= maxLength) {
                max = maxLength;
            }
        }

        System.out.println(max + maxNum);
//        return max + maxNum;
    }
}
