package doy.math1_1;

import java.util.Scanner;

public class Doy_Q2609 {
    // 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
    static Scanner s = new Scanner(System.in);
    public static void run() {
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        int max = num1 > num2 ? num1 : num2;

        for (int i=max; i>0; i--) {
            if(num1%i == 0 && num2%i == 0){
                int gcd = i;
                int lcm = num1*num2 / gcd;

                System.out.println(gcd);
                System.out.println(lcm);

                break;
            }
        }
    }

    /*
    public static int getGCD(int num1, int num2) {
        if(num2 == 0)
            return num1;
        else
            return getGCD(num2, num1 % num2);
    }

    public static int getLCM(int num1, int num2, int gcd) {
        return gcd * (num1/gcd) * (num2/gcd);
    }
    */
}

/*
    gcd와 lcm을 간단하게 풀기 좋은 방법 같아요. 따로 함수로 빼지 않고 짧은 시간내에 작성할 수 있는 방법이라고 생각합니다.
    그리고 max에서 하나씩 줄이면서 최대공약수를 바로 찾는 방법이 있다는 것을 알았네요 :)
    저는 2부터 min까지 전부 조사해서 최대공약수를 찾는 방법을 사용했습니다. 시간복잡도는 크게 차이가 나진 않을 거 같아요.
    int lcm = num1 * num2 / gcd; 를 생각하고 있다면 gcd만 빠르게 구현한 후에 쉽게 lcm도 구할 수 있을 거 같아요.
*/
