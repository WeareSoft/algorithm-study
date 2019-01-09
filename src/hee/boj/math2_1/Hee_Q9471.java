package hee.boj.math2_1;

import java.util.Scanner;

// 피보나치 수열을 m으로 나눈 나머지가 주기를 이룬다
// m이 주어졌을 때, k(m)(반복하는 부분 수열의 길이)을 구하는 프로그램
// 첫째 줄에 테스트 케이스의 개수 P (1 ≤ P ≤ 1000)
// N은 테스트 케이스의 번호이고, M은 문제에서 설명한 m이다. (2 ≤ M ≤ 1,000,000)
public class Hee_Q9471 {
    static Scanner scanner = new Scanner(System.in);

    static int pisanoPeriod(int modNum){
        int result = 0;

        int a = 1, b = 1, c;

        while (true){
            c = (a + b) % modNum;
            b = a;
            a = c;
            result++;

            if (a == 1 && b == 1){
                return result;
            }
        }
    }

    public static void run(){
        int p = scanner.nextInt();

        while (p > 0){
            int i = scanner.nextInt();
            int modNum = scanner.nextInt();

            System.out.println(i + " " + pisanoPeriod(modNum));

            p--;
        }

    }
}
/*
    풀이가 동일하네요 :)
    피사노 주기는 두번 째 1, 1이 나올 때까지 구하면 된다는 걸 알게 됐습니당 ^^
*/
