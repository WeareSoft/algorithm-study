package hee.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hee_Q2455 {
    static int add, sub;
    static ArrayList<Integer> people = new ArrayList();

    public static void run() {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sub = sc.nextInt();
            add = sc.nextInt();

            sum += add - sub;
            people.add(sum);
        }
        System.out.println(Collections.max(people));
    }
}
