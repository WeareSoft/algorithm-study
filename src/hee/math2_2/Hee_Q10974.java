package hee.math2_2;

import java.util.Scanner;

// N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램
// 첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
// 첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.
public class Hee_Q10974 {
    static Scanner scanner = new Scanner(System.in);

    // 사전순으로 다음에 오는 순열을 구하는 프로그램
    static boolean next_permutation(int[] arrays) {
        // 1. A[i-1] < A[i]를 만족하는 가장 큰 i를 찾는다.
        // (즉, 순열의 마지막 수에서 끝나는 가장 긴 감소수열을 찾는다.)
        int i = arrays.length - 1;
        while (i > 0 && arrays[i-1] >= arrays[i])
            i--;

        // 마지막 순열 (이미 사전순으로 정렬된 상태, 전체가 감소수열)
        if (i <= 0)
            return false;

        // 2. j>=i 이면서 A[j] > A[i-1]를 만족하는 가장 큰 j를 찾는다.
        int j = arrays.length - 1;
        while (arrays[j] <= arrays[i-1])
            j--;

        // 3. A[i-1]과 A[j]를 swap한다.
        int tmp;
        tmp = arrays[i-1];
        arrays[i-1] = arrays[j];
        arrays[j] = tmp;

        // 4. A[i]부터 순열을 뒤집는다.
        int k = arrays.length - 1;
        while (i < k) {
            tmp = arrays[i];
            arrays[i] = arrays[k];
            arrays[k] = tmp;
            i++;
            k--;
        }
        return true;
    }

    public static void run(){
        int N = scanner.nextInt();
        int[] arrays = new int[N];
        int num = 0;

        for (int i=0; i<N; i++){
            arrays[i] = ++num;
            System.out.print(arrays[i] + " ");
        }
        System.out.println();

        // 마지막 순열이 될 때까지 출력
        while (next_permutation(arrays)){
            for (int i=0; i<arrays.length; i++)
                System.out.print(arrays[i] + " ");
            System.out.println();
        }
    }
}
