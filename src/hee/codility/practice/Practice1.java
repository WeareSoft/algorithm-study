package hee.codility.practice;

public class Practice1 {
    public int solution(int[] A) {

        int[] num1 = new int[]{0, A[0]};
        int[] num2 = new int[]{1, A[1]};
        int length = 2, max = 2;
        for (int i = 2; i < A.length; i++) {
            int checkNum = A[i];
            if (checkNum == num1[1]) {
                num1[0] = i;
                length++;
            } else if (checkNum == num2[1]) {
                num2[0] = i;
                length++;
            } else {
                if (A[i - 1] == num1[1]) {
                    length = i - num2[0];
                    num2[0] = i;
                    num2[1] = checkNum;
                } else {
                    length = i - num1[0];
                    num1[0] = i;
                    num1[1] = checkNum;
                }
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
