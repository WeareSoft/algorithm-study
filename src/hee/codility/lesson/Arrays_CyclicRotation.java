package hee.codility.lesson;

public class Arrays_CyclicRotation {
    // [TIP] input ([], 0) 생각
    public int[] solution(int[] A, int K) {
        int length = A.length;
        if (length == 0) {
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
