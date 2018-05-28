package doy;

import java.util.Scanner;

public class Doy_Q1934 {
    // 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
    static Scanner s = new Scanner(System.in);
    public static void run() {
        int count = s.nextInt();
        for(int i=0; i<count; i++) {
            int num1 = s.nextInt();
            int num2 = s.nextInt();
            int max = num1 > num2 ? num1 : num2;

            for (int j = max; j > 0; j--) {
                if (num1 % j == 0 && num2 % j == 0) {
                    int gcd = j;
                    int lcm = num1 * num2 / gcd;

                    System.out.println(lcm);
                    break;
                }
            }
        }
    }
}

/*
    test case에 대해서 전체를 한 번에 입력받지 않아도 되는 것을 알았어요.
    1) 전체 입력이 큰 경우에는 그만큼 큰 배열이 필요하기 때문에
    2) 받는 입력의 개수를 모를 때 배열의 크기를 정하기 어렵기 때문에
    
    한 번 더 정리하고 갑니다 :)
    
    일일이 비교해서 gcd를 찾는 방법보다 속도가 빠른 유클리드 호제법에 관한 내용을 같이 정리해보면 좋을 거 같아요~
*/
