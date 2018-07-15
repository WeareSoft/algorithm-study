package hee.math2_2;

import java.util.Scanner;

// 길이 L이 주어졌을 때 길이가 L인 서로 다른 올바른 괄호 문자열의 개수를 출력하는 프로그램을 만들어 보자.
// 각 테스트 케이스에 대해 길이가 L인 올바른 괄호 문자열의 개수를 1,000,000,007로 나눈 나머지를 출력하시오.
public class Hee_Q10422{
    static Scanner scanner = new Scanner(System.in);
    static final int MOD = 1000000007;

    /* long 범위 초과 -> MOD를 BL안에 넣기 */
    // [방법1] 이항계수 C(n, k) 구하기
    // 카탈란의 수 Cn = (2nCn) / (n+1)
    static long binomialCoeff(int n, int k) {
        long res = 1;

        // C(n, k) = C(n, n-k)
        if (k > n - k)
            k = n - k;

        // nCk = [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
        for (int i = 0; i < k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    /* 시간 초과 */
    // [방법2] 재귀함수를 통한 카탈란의 수 구하기
    // Cn+1 = sum{i=0~n}(Ci * Cn-i)
    // 카탈란의 수 Cn = sum{i=0~(n-1)}(Ci * Cn-i-1)
    static long getCatalan(int n){
        int res = 0;

        if (n <= 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            res += getCatalan(i) * getCatalan(n - i - 1);
        }
        return res;
    }

    // [방법 3] 반복문을 통한 카탈란의 수 구하기
    // A에 괄호가 k쌍이 있다면 B에는 n−1−k쌍이 있어야 한다.
    // 카탈란의 수 Cn = sum{i=0~(n-1)}(Ci * Cn-i-1)
    static long getCatalan2(int n){
        long d[] = new long[2501];
        d[0] = 1; // C0 = 1

        // EX) C4 = C0C3 + C1C2 + C2C1 + C3C0
        for (int i = 1; i <= 2500; i++){
            d[i] = 0;

            for(int j = 0; j < i; j++){
                d[i] += d[j] * d[i-1-j];
                d[i] %= MOD;
            }
            d[i] %= MOD;
        }
        return d[n];
    }

    // 단, 여는 괄호와 닫는 괄호가 n일 때
    // ** 카탈란의 수 Cn: 2nCn − 2nCn+1 = (2nCn) / (n+1)
    public static void run(){
        int t = scanner.nextInt();

        // (1 ≤ N ≤ 5000)
        while (t > 0){
            int N = scanner.nextInt(); // 괄호 문자열의 길이
            int n = N/2; // 여는 괄호와 닫는 괄호의 수

            if(N % 2 == 0) {
//                System.out.println((binomialCoeff(2 * n, n) / (n+1)) % MOD);
//                System.out.println(getCatalan(n) % MOD);
                System.out.println(getCatalan2(n));
            }
            // 괄호 문자열의 길이가 홀수이면 올바른 문자열이 나올 수 없다.
            else System.out.println("0");

            t--;
        }
    }
}

// Reference : http://suhak.tistory.com/77
// Reference : https://www.geeksforgeeks.org/program-nth-catalan-number/

/*
    저한테는 카탈란의 수는 개념 이해 자체가 어렵네요 ㅠㅠ
    이번 스터디에서 정확한 이해를 하고 넘어가는걸 목표로 해야겠어요 ㅎㅎ
*/
