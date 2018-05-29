package hee;

import java.util.*;

// 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.
public class Hee_Q9613 {
    static Scanner scanner = new Scanner(System.in);

    public static int gcd(int num1, int num2){
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
            Integer[] nums = new Integer[count];

            for (int j=0; j<count; j++){
                nums[j] = scanner.nextInt();
            }

            int num1, num2 = 0;
            int sumGCD = 0;

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
