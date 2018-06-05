package doy;

import java.util.Scanner;

public class Doy_Q11653 {
    static Scanner s = new Scanner(System.in);
    public static void run() {
        int n = s.nextInt();

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                System.out.println(i);
                n /= i;
            }
        }

        if (n > 1) {
            System.out.println(n);
        }
    }
}
