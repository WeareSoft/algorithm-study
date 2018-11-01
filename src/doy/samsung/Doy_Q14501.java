package doy.samsung;

import java.util.ArrayList;
import java.util.Scanner;

/* [퇴사] https://www.acmicpc.net/problem/14501 */
public class Doy_Q14501 {
    static Scanner s = new Scanner(System.in);
    static int n;
    static int[] t, p;
    static ArrayList<Integer> consult = new ArrayList();
    static int res = Integer.MIN_VALUE;

    public static void run() {
        n = s.nextInt();
        t = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {
            t[i] = s.nextInt();
            p[i] = s.nextInt();
        }

        dfs(0);
        System.out.println(res);
    }

    public static void dfs(int day) {
        // 현재 날이 퇴사일을 넘어가면 상담을 할 수 없으므로 종료
        if (day >= n) {
            int profit = 0;
            int size = consult.size();

            // day > n 보다 큰 경우는 상담을 할 수 없는데 consult에 들어가 있으므로 그 전에 저장된 날까지 계산
            if (day > n) {
                size--;
            }
            for (int i = 0; i < size; i++) {
                int date = consult.get(i);
                profit += p[date];
            }

            res = Math.max(res, profit);
            return;
        }

        for (int i = day; i < n; i++) {
            // 현재 날짜 추가
            consult.add(i);
            // 현재일 + 상담일 이후 날짜 선택하기 위해 상담일 더함
            dfs(i + t[i]);
            // backtracking
            consult.remove(consult.size() - 1);
        }
    }
}