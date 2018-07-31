package hee.math1_2;

import java.util.Scanner;

public class Hee_Q2004 {
    static Scanner scanner = new Scanner(System.in);

    // nCm의 끝자리 0의 개수를 출력하는 프로그램을 작성하시오.
    // 첫째 줄에 정수 n, m(0≤m≤n≤2,000,000,000, n!=0)이 들어온다.
    // nCm = n! / (m! * (n-m)!)
    public static void run(){
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 0!=1, 0C0=1, nC0=1, nCn=1
        if(n == 0 || m == 0){
            System.out.print("0");
            return;
        }

        // num를 소인수분해 했을 때 (2*5)의 개수가 0의 개수이다
        // 조합에서는 5의 개수가 항상 2의 개수보다 적은지 알 수 없으므로
        // 2와 5의 개수를 모두 확인한다
        int countOfTwo = 0;
        long i=2;
        while (i<=n){
            countOfTwo += (n/i);

            if(i<=m){
                countOfTwo -= (m/i);
            }
            if(i<=n-m){
                countOfTwo -= ((n-m)/i);
            }
            i*=2;
        }

        int countOfFive = 0;
        long j=5;
        while (j<=n){
            countOfFive += (n/j);

            if(j<=m){
                countOfFive -= (m/j);
            }
            if(j<=n-m){
                countOfFive -= ((n-m)/j);
            }
            j*=5;
        }

        System.out.print(Math.min(countOfTwo, countOfFive));
    }

//    static int countOfNum(int x, int num) {
//        int cnt;
//        for(cnt=0; x>0; x/=num)
//            cnt += x/num;
//        return cnt;
//    }

}
