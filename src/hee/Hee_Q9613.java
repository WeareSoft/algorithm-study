package hee;

import java.util.*;

// 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
public class Hee_Q9613 {
    static Scanner scanner = new Scanner(System.in);

    public static long gcd(long num1, long num2){
        if(num2 == 0){
            return num1;
        }else {
            return gcd(num2, num1%num2);
        }
    }

    public static void run(){
        int testcase = scanner.nextInt();

        for(int i=0; i<testcase; i++){
            int count = scanner.nextInt();
            Long[] nums = new Long[count];

            for (int j=0; j<count; j++){
                nums[j] = scanner.nextLong();
            }

            long num1, num2 = 0;
            long sumGCD = 0;

            for(int j=0; j<nums.length-1; j++){
                num1 = nums[j];

                for(int k=j+1; k<nums.length; k++){
                    num2 = nums[k];
                    sumGCD += gcd(num1, num2);
                }
            }
            System.out.println(sumGCD);
        }
    }
}

/*
    풀이가 같네요 :)
    앞으로는 입출력 범위를 잘 확인하고 자료형을 선택해야겠어요!!
*/
