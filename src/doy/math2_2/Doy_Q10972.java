package doy.math2_2;

import java.util.Scanner;

// 1부터 N까지의 수로 이루어진 순열이 있다. 이 때, 사전순으로 다음에 오는 순열을 구하는 프로그램을 작성하시오.
public class Doy_Q10972 {
    static Scanner s = new Scanner(System.in);

    public static void run() {
        int count = s.nextInt();
        int[] numArray = new int[count];

        for (int i = 0; i < count; i++) {
            numArray[i] = s.nextInt();
        }

        if (nextPermutation(numArray)) {
            for (int i = 0; i < count; i++) {
                System.out.print(numArray[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean nextPermutation(int[] a) {
        // 1. a[i-1] < a[i]를 만족하는 가장 큰 i를 찾는다. (순열의 마지막 수에서 끝나는 가장 긴 감소수열)
        int i = a.length - 1;
        while (i > 0 && a[i-1] >= a[i]) {
            i--;
        }

        // 마지막 순열
        if (i <= 0) {
            return false;
        }

        // 2. j>=i 이면서 a[j] > a[i-1]를 만족하는 가장 큰 j를 찾는다.
        int j = a.length - 1;
        while (a[j] <= a[i-1]) {
            j--;
        }

        // 3. a[i-1]과 a[j]를 바꾼다.
        swap(a, i-1, j);

        // 4. a[i]부터 순열을 뒤집는다.
        j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }

        return true;
    }

    private static void swap(int[] a, int idx1, int idx2) {
        int temp;
        temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }
}
