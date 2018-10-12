package hee.samsung;

import java.util.Scanner;

/**
 * 브루트 포스 - 모든 순열에 대한 조합 (n! 개)
 *
 * [방법1]: 연산자의 종류를 기준 [방법2]: 연산자 조합 배열(n-1개)을 기준
 */
public class Hee_Q14888 {
    static int n;
    static int maxSum = Integer.MIN_VALUE;
    static int minSum = Integer.MAX_VALUE;

    static int[] numbers; // 연산에 필요한 고정 숫자들
    static int[] operatorCnt = new int[4]; // 연산자의 수에 대한 배열

    static int[] operator; // 연산자 조합에 대한 배열 (index를 값으로 저장)
    static boolean[] visited; // 연산자 조합의 방문 여부

    public static void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        numbers = new int[n];
        for (int i = 0; i < n; i++)
            numbers[i] = sc.nextInt();

        // [방법2]
        operator = new int[n - 1];
        visited = new boolean[n - 1];
        int index = 0;

        for (int i = 0; i < 4; i++) {
            int cntOpr = sc.nextInt(); // 연산자의 수
            operatorCnt[i] = cntOpr;

            // [방법2]
            for (int j = 0; j < cntOpr; j++) { // 연산자의 수 만큼 해당 index를 연산자 조합 배열에 삽입.
                operator[index] = i; // (index 0:+, 1:-, 2:*, 3:/)
                index++;
            }
        }

//		dfs(0, numbers[0]);
        dfs2(0, 0, numbers[0]); // [방법2]

        System.out.println(maxSum);
        System.out.println(minSum);
    }

    /* [방법1] 연산자의 종류를 기준으로 조합을 만든다.(훨씬 빠름) */
    public static void dfs(int depth, int sum) {
        // [출력] 연산자의 수만큼 조합했다면 최소, 최대값 출력.
        if (depth == n - 1) {
            maxSum = Math.max(maxSum, sum);
            minSum = Math.min(minSum, sum);
//			return;
        }

        // [재탐색] 다음 연산자 선택
        for (int i = 0; i < 4; i++) {
            if (operatorCnt[i] != 0) { // 해당 연산자의 수가 남아있는 경우에만 사용 가능.
                // 해당 연산자 사용
                operatorCnt[i]--;
                // 연산자에 따른 수식 계산 후 다음 연산자 선택
                switch (i) {
                    case 0: // +
                        dfs(depth + 1, sum + numbers[depth + 1]);
                        break;
                    case 1: // -
                        dfs(depth + 1, sum - numbers[depth + 1]);
                        break;
                    case 2: // *
                        dfs(depth + 1, sum * numbers[depth + 1]);
                        break;
                    case 3: // /
                        dfs(depth + 1, sum / numbers[depth + 1]);
                        break;
                }
                // backtracking
                operatorCnt[i]++;
            }
        }
    }

    /* [방법2] 연산자 조합 배열(n-1개)을 기준으로 조합을 만든다. */
    public static void dfs2(int start, int depth, int sum) {
        // [출력] 연산자의 수만큼 조합했다면 최소, 최대값 출력.
        if (depth == n - 1) {
            maxSum = Math.max(maxSum, sum);
            minSum = Math.min(minSum, sum);
//			return; // [주의] 있으면 틀림. 밑에 backtracking을 수행해야하므로
        }

        int result = 0;
        // [재탐색] 다음 연산자 선택
        for (int i = 0; i < n - 1; i++) { // 처음부터 끝까지 반복
            if (!visited[i]) { // 처음부터 반복했을 때 앞에서 선택하지 않은 것을 선택.
                // 방문 표시
                visited[i] = true;
                switch (operator[i]) {
                    case 0:
                        result = sum + numbers[depth + 1];
                        break;
                    case 1:
                        result = sum - numbers[depth + 1];
                        break;
                    case 2:
                        result = sum * numbers[depth + 1];
                        break;
                    case 3:
                        result = sum / numbers[depth + 1];
                        break;
                }
                // 다음 단계 수행. start root는 자기 자신부터 다시 탐색.
                dfs2(i, depth + 1, result);
            }
        }
        // backtracking [주의] for문 밖에서 처리
        visited[start] = false;
    }
}