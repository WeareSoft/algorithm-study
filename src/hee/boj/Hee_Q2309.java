package hee.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hee_Q2309 {
    static int[] person = new int[9];
    static ArrayList<Integer> selected = new ArrayList();
    static ArrayList<Integer> result = new ArrayList();
    static int sum = 0;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            person[i] = sc.nextInt();
        }
        dfs(0, 0);
    }

    public static void dfs(int start, int depth) {
        if (depth == 7) {
            if (sum == 100) {
                for (int i = 0; i < selected.size(); i++) {
                    int idx = selected.get(i);
                    result.add(person[idx]);
                }

                Collections.sort(result);
                for (int i = 0; i < result.size(); i++) {
                    System.out.println(result.get(i));
                }
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            selected.add(i);
            sum += person[i];
            dfs(start + 1, depth + 1);
            selected.remove(selected.size() - 1);
            sum -= person[i];
        }
    }
}
