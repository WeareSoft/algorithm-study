package hee.samsung;

import java.util.ArrayList;
import java.util.Scanner;

public class Hee_Q14889 {
    static int N;

    static int[][] ability;
    static ArrayList<Integer> selected;
    static boolean[] visited;

    static int minDiff = Integer.MAX_VALUE;

    public static void run() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 짝수
        ability = new int[N][N];
        selected = new ArrayList(); // 조합으로 고른 팀원
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ability[i][j] = sc.nextInt();
            }
        } // 입력 끝.

//		dfs1(0, 0);
        dfs2(0, 0);
        System.out.println(minDiff);
    }

    /** 방법 1: ArrayList 이용 */
    public static void dfs1(int start, int depth) {
        if (depth == (N / 2)) { /* 선택한 조합의 개수가 최종 팀원의 수이면 */
            // [출력]
            ArrayList<Integer> teamA = new ArrayList();
            ArrayList<Integer> teamB = new ArrayList();

            // 해당 조합의 팀(A팀)과 그 나머지 팀(B팀)을 세팅.
            for (int i = 0; i < N; i++) {
                if (selected.contains(i))
                    teamA.add(i);
                else
                    teamB.add(i);
            }

            // 두 팀의 능력치를 구하고 그 차이가 이전에 구한 값들보다 작으면 minDiff 변경.
            int diff = Math.abs(getTeamAbility(teamA) - getTeamAbility(teamB));
            minDiff = Math.min(minDiff, diff);

            return;
        }
        /* 팀을 구성하지 못했으면 다음 노드로 재탐색 [조합 미완성] */
        for (int i = start; i < N; i++) {
            selected.add(i);
            dfs1(i + 1, depth + 1);
            selected.remove(selected.size() - 1);
        }
    }

    public static int getTeamAbility(ArrayList<Integer> team) {
        int teamAbility = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = i + 1; j < team.size(); j++) {
                teamAbility += getCombiAbility(team.get(i), team.get(j));
            }
        }
        return teamAbility;
    }

    public static int getCombiAbility(int i, int j) {
        return ability[i][j] + ability[j][i];
    }

    /** 방법 2:  boolean[] 이용 */
    public static void dfs2(int start, int depth) {
        if (depth == (N / 2)) { /* 선택한 조합의 개수가 최종 팀원의 수이면 */
            // [출력]
            int teamA_Ability = 0;
            int teamB_Ability = 0;

            // 두 팀의 능력치를 구한다.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i] && visited[j]) { // visited가 true이면 스타트 팀.
                        teamA_Ability += ability[i][j];
                    } else if (!visited[i] && !visited[j]) { // visited가 false이면 링트 팀.
                        teamB_Ability += ability[i][j];
                    }
                }
            }

            // 두 팀의 능력치 차이가 이전에 구한 값들보다 작으면 minDiff 변경.
            int diff = Math.abs(teamA_Ability - teamB_Ability);
            minDiff = Math.min(minDiff, diff);

            return;
        }
        /* 팀을 구성하지 못했으면 다음 노드로 재탐색 [조합 미완성] */
        for (int i = start; i < N; i++) {
            visited[i] = true;
            dfs2(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}