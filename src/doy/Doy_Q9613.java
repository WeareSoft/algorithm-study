package doy;

import java.util.Scanner;

public class Doy_Q9613 {
    // 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
    // 첫째 줄에 테스트 케이스의 개수 t (1 < t < 100)이 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 첫째 줄에는 수의 개수 n (1 < n < 100)가 주어지고, 다음에는 n개의 수가 주어진다. 입력으로 주어지는 수는 1000000을 넘지 않는다.
    static Scanner s = new Scanner(System.in);
    public static void run() {
        int t = s.nextInt();
        while (t > 0) {
            int n = s.nextInt();
            int[] numArray = new int[n];
            for (int i=0; i<n; i++) {
                numArray[i] = s.nextInt();
            }

            int sum = 0;
            for (int i=0; i<n-1; i++) {
                for (int j=i+1; j<n; j++) {
                    sum += gcd(numArray[i], numArray[j]);
                }
            }

            System.out.println(sum);

            t--;
        }
    }

    static int gcd(int x, int y) {
        if(y == 0) {
            return x;
        }
        else {
            return gcd(y, x%y);
        }
    }
}


/*
    풀이가 똑같네요^^
    다만 자료형을 int로 했을 때와 long으로 했을 때의 차이를 제대로 알고 가야할 거 같아요.
    자료형의 범위에 대해 같이 알아보고 앞으로는 문제 조건에 따라 알맞은 자료형을 선택해봅시다~
*/
