package hee.boj;

import java.util.ArrayList;
import java.util.Scanner;

// 로또
public class Hee_Q6603 {
    static int k;
    static int[] s;
    static boolean[] visited;
    static ArrayList<Integer> print = new ArrayList<Integer>();

    public static void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            k = sc.nextInt(); // 집합 S에 포함되는 수
            if (k == 0) // 종료 조건.
                return;

            s = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                s[i] = sc.nextInt();
            }

            dfs(0, 0);
            System.out.println();
        }
    }

    static void dfs(int start, int depth) {
        // 출력
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if(visited[i])
                    System.out.print(s[i] + " ");
            }
            System.out.println();
            return;
        }

        // 재탐색.
        for (int i = start; i < k; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
