package hee.samsung;

import java.util.ArrayList;
import java.util.Scanner;

/** DP(다이나믹 프로그래밍) 또는 DFS */
public class Hee_Q14501 {
    static int n;
    static int leaveDay; // 퇴사일
    static int[] t, p;

    static int[] dp; // 메모이제이션
    static ArrayList<Integer> consult = new ArrayList(); // 상담받는 날

    static int res = Integer.MIN_VALUE; // 최대 이익

    public static void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n일까지의 일정표
        leaveDay = n + 1; // 퇴사일

        t = new int[n + 10]; // DP: (마지막날+5일)일 때 배열 에러가 날 수 있으므로 넉넉히 잡아준다.
        p = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt(); // 상담을 완료하는데 걸리는 기간
            p[i] = sc.nextInt(); // 상담을 했을 때 받을 수 있는 금액
        } // input

        /* 완전탐색 풀이 */
        // [방법1] 1일부터 시작
        dfs1(1, 0);
        // [방법2] 1일부터 시작
        dfs2(1);
        // [방법3] 상담 시작일을 (1일 ~ 1일의 상담이 끝나는 날)순차적으로 설정
        for (int i = 1; i <= t[1]; i++) {
            if (i >= leaveDay)
                break;
            consult.add(i);
            dfs3(i);
            consult.remove(consult.size() - 1);
        }

        /* DP 풀이 */
        dp = new int[n + 10]; // 메모이제이션
        dp1(); // [방법1]
        dp2(); // [방법2]
        dp3(); // [방법3]

        System.out.println(res);
    }

    public static void dfs1(int day, int sum) { // refe: http://donggod.tistory.com/21
        // [출력]
        // 점검할 날짜가 퇴사일을 지나면 최대값을 변경.
        if (day >= leaveDay) {
            res = Math.max(res, sum);
            return;
        }

        /* [재탐색] 1. 상담을 하는 경우와 2. 하지 않는 경우에 대해 각각 DFS 재귀 호출. */
//		if (day <= N) {
        // 1. 상담을 안하는 경우: 수익 없이 바로 다음날로 넘어감
        dfs1(day + 1, sum);
//		}

        // 2. 상담하는 경우: 해당 날짜의 상담이 끝나는 날(endDay)이 퇴사일 전이면 상담 가능.
        int endDay = day + t[day] - 1;
        if (endDay < leaveDay) {
            // 해당 날짜의 수익과 함께 상담을 마친 다음날(endDay + 1)로 넘어감.
            dfs1(endDay + 1, sum + p[day]);
        }
    }

    public static void dfs2(int day) {
        // [종료] 점검해야하는 날이 퇴사일 이후면 종료.
        if (day >= leaveDay) {
            int size = consult.size();
            // 점검하는 날이 퇴사일이 아니면 이전의 상담은 불가능하므로 크기 하나 감소
            if (day != leaveDay)
                size--;

            // 상담받는 날의 금액을 합한다.
            int profit = 0;
            for (int i = 0; i < size; i++) {
                int date = consult.get(i);
                profit += p[date];
            }

            // 최대 이익을 변경한다.
            res = Math.max(res, profit);
            return;
        }

        // 상담 시작일(1 ~ n일)을 순차적으로 설정
        for (int i = day; i <= n; i++) {
            consult.add(i); // 상담하는 날로 추가
            dfs2(i + t[i]); // [주의] 상담을 완료한 다음날을 점검
            consult.remove(consult.size() - 1); // 백트래킹
        }
    }

    public static void dfs3(int day) {
        int endDay = day + t[day] - 1;

        // [종료] 해당일의 상담이 끝나는 날이 퇴사일을 넘어가면 상담 불가능
        if (endDay + 1 >= leaveDay) {
            int size = consult.size();
            // 점검하는 날이 퇴사일이 아니면 이전의 상담은 불가능하므로 크기 하나 감소
            if (endDay + 1 != leaveDay)
                size--;

            // 상담받는 날의 금액을 합한다.
            int profit = 0;
            for (int i = 0; i < size; i++) {
                int date = consult.get(i);
                profit += p[date];
            }

            // 최대 이익을 변경한다.
            res = Math.max(res, profit);
            return;
        }

        for (int i = day; i <= n; i++) {
            // 상담을 완료한 다음날부터 상담 가능
            if (i >= endDay + 1) {
                consult.add(i); // 상담하는 날로 추가
                dfs3(i);
                consult.remove(consult.size() - 1); // 백트래킹
            }
        }
    }

    public static void dp1() { // refe: http://zoonvivor.tistory.com/148
        int max = 0;

        for (int day = 1; day <= leaveDay; day++) {
            // 1. 이전까지의 최대 수익을 비교해서 최대 수익을 현재에도 저장한다.
            dp[day] = Math.max(dp[day], max);

            // 2. 이전에 저장된 최대 수익(상담 완료 후 날짜의 최대 수익)과
            // 이번에 상담을 받고 다른 날로 이동 시 생기는 수익(오늘 버는 수익 + 오늘 이전까지 번 수익)
            int endDay = day + t[day]; // 상담 끝나는 다음날
            dp[endDay] = Math.max(dp[endDay], p[day] + dp[day]);

            max = Math.max(max, dp[day]);
        }
        res = max;
    }

    public static void dp2() { // refe: http://hyeooona825.tistory.com/58
        for (int day = 1; day < leaveDay; day++) {
            dp[day + 1] = Math.max(dp[day], dp[day + 1]);

            int nextDay = day + t[day]; // 상담 끝나는 다음날.
            if (nextDay <= leaveDay) {
                dp[nextDay] = Math.max(dp[nextDay], dp[day] + p[day]);
            }
        }
        res = dp[leaveDay];
    }

    public static void dp3() { // refe: http://donggod.tistory.com/21
        int max = 0;

        for (int day = 1; day < leaveDay; day++) {
            int nextDay1 = day + 1; // 바로 다음날.
            int nextDay2 = day + t[day]; // 상담 끝나는 다음날.

            if (nextDay1 <= leaveDay)
                dp[nextDay1] = Math.max(dp[nextDay1], dp[day]);

            if (nextDay2 <= leaveDay)
                dp[nextDay2] = Math.max(dp[nextDay2], dp[day] + p[day]);

            int subMax = Math.max(max, dp[nextDay2]);
            max = Math.max(subMax, dp[nextDay1]);
        }
        res = max;
    }
}
