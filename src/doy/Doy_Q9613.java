package doy;

import java.util.Scanner;

public class Doy_Q9613 {
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
