package hee.codility.w;

import java.util.Arrays;

public class Q1_4 {
    public static void main(String[] args) {
//        int A = 1, B = 1, C = 2, D = 3;
        int A = 2, B = 4, C = 2, D = 4;

        int nums[] = new int[3];
        nums[0] = squaredDistance(A, B, C, D);
        nums[1] = squaredDistance(A, C, B, D);
        nums[2] = squaredDistance(A, D, B, C);

        Arrays.sort(nums);
        System.out.println(nums[2]);
//        return nums[2];
    }

    private static int squaredDistance(int n1, int n2, int n3, int n4) {
        return (int) Math.pow(n1 - n2, 2) + (int) Math.pow(n3 - n4, 2);
    }
}
