package hee.codility.lesson;

public class Arrays_CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8

        int length = A.length;
        if (length == 0) { // input ([], 0) 생각
            return A;
        }

        K = K % length;
        int[] B = new int[length];
        for (int i = 0; i < length; i++) {
            B[(i + K) % length] = A[i];
        }
        return B;
    }
}
