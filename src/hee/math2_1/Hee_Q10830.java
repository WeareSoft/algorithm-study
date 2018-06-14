package hee.math2_1;

import java.util.Scanner;

// 크기가 N*N인 행렬 A가 주어진다. 이 때, A의 B제곱을 구하는 프로그램을 작성하시오.
// 수가 매우 커질 수 있으니, A^B의 각 원소를 1,000으로 나눈 나머지를 출력한다.
// (2 ≤ N ≤  5, 1 ≤ B ≤ 100,000,000,000)
public class Hee_Q10830 {
    static Scanner scanner = new Scanner(System.in);

    static long[][] mulMatrix(long[][] tmp1, long[][] tmp2){
        int n = tmp1.length;
        long newMatrix[][] = new long[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    newMatrix[i][j] += tmp1[i][k] * tmp2[k][j];
                }
                newMatrix[i][j] %= 1000;
            }
        }
        return newMatrix;
    }

    public static void run(){
        int n = scanner.nextInt();
        long b = scanner.nextLong();

        long matrix[][] = new long[n][n];
        long resultMatrix[][] = new long[n][n];

        /* 값 입력 */
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                matrix[i][j] = scanner.nextInt();
            }
            // (1 0)
            // (0 1)
            resultMatrix[i][i] = 1;
        }

        /* 이진수를 이용한 곱셈 */
        while (b > 0){
            if (b%2 == 1){
                resultMatrix = mulMatrix(resultMatrix, matrix);
            }
            matrix = mulMatrix(matrix, matrix);
            b /= 2;
        }

        /* 값 출력 */
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
