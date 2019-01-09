package hee.boj.math2_2;

import java.util.Scanner;

// k가 주어지면 k번째 순열을 구하고, 임의의 순열이 주어지면 이 순열이 몇 번째 순열인지를 출력하는 프로그램
// 1인 경우 k(1≤k≤N!)를 입력받고, 2인 경우 임의의 순열을 나타내는 N개의 수를 입력받는다.
// k번째 수열을 나타내는 N개의 수를 출력하거나, 몇 번째 수열인지를 출력하면 된다.
public class Hee_Q1722 {
    static Scanner scanner = new Scanner(System.in);

    // 1. k번째 순열이 어떤 순열인지
    static int[] permutationOfIndex(int N, long k){
        boolean[] checkPermutation = new boolean[N+1]; // default가 false
        int[] arrays = new int[N];

        // 팩토리얼 배열
        long[] factorial = new long[N+1];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i=1; i<N; i++){
            factorial[i] = factorial[i-1] * i;
//            System.out.println("i: " + i + " , factorial: " + factorial[i]);
        }

        for (int i=0; i<N; i++){
            for (int j=1; j<=N; j++){
                // 앞에서 할당하지 않은 값에 대해서만 체크한다.
                if(checkPermutation[j] == true){
                    continue;
                }
                if(k > factorial[N-1-i]){
                    k -= factorial[N-1-i];
//                    System.out.println("k: " + k + ", factorial: " + factorial[N-1-i]);
                } else {
                    arrays[i] = j;
                    checkPermutation[j] = true; // 해당 숫자에 대해서는 값을 할당함
                    break;
                }
            }
        }
        return arrays;
    }

    // 2. 해당 순열이 몇 번째 순열인지
    static long indexSequence(int[] arrays) {
        /* [방법1] */
//        int N = arrays.length;
//        boolean[] checkPermutation = new boolean[N+1]; // default가 false
//
//        // 팩토리얼 배열
//        long[] factorial = new long[N+1];
//        factorial[0] = 1;
//        factorial[1] = 1;
//        for (int i=1; i<N; i++){
//            factorial[i] = factorial[i-1] * i;
////            System.out.println("i: " + i + " , factorial: " + factorial[i]);
//        }
//
//        long result = 0;
//        for (int i=0; i<N; i++) {
//            for (int j=1; j<arrays[i]; j++) {
//                if (checkPermutation[j] == false) {
//                    result += factorial[N-i-1];
//                }
//            }
//            checkPermutation[arrays[i]] = true;
//        }
//        return result + 1; // 순서는 1부터 시작


        /* [방법2] */
//        // 팩토리얼 개수에 대한 배열
        int N = arrays.length;
        long[] factorial = new long[N+1];

        for (int i=0; i<N; i++){
            for (int j=i+1; j<N; j++){
                if (arrays[i] > arrays[j]){
                    factorial[N-1-i]++;
                }
            }
        }
        // for문을 이용한 팩토리얼의 계산
        long result = 0;
        for (int i=N-1; i>=1; i--){
            long fac = 1;
            for (int j=i; j>=1; j--) {
                fac = fac * j;
            }
            // 팩토리얼 값 * 해당 팩토리얼 개수
            result += (fac * factorial[i]);
        }
        return result + 1; // 순서는 1부터 시작
    }

    public static void run(){
        int N = scanner.nextInt();
        int[] arrays = new int[N];

        int selection = scanner.nextInt();

        if(selection == 1){
            long k = scanner.nextLong();
            // 1. k번째 수열 출력
            arrays = permutationOfIndex(N, k);
            for (int i=0; i<arrays.length; i++){
                System.out.print(arrays[i] + " ");
            }
        }
        else {
            // 2. N개의 배열을 입력받은 대로 세팅
            for (int i=0; i<N; i++){
                arrays[i] = scanner.nextInt();
            }
            System.out.println(indexSequence(arrays));
        }
    }
}

