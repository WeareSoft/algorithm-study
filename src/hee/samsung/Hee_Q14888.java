package hee.samsung;

import java.util.Scanner;

/**
 * 연산자
 * -> 모든 순열에 대한 조합 (n! 개)
 * -> 완전탐색 이용. */
public class Hee_Q14888 {
    static int N;
    static int maxSum = Integer.MIN_VALUE;
    static int minSum = Integer.MAX_VALUE;

    static int[] numbers; // 연산에 필요한 고정 숫자들
    static int[] operator; // 연산자 조합에 대한 배열 (index를 값으로 저장)
    static boolean[] visited; // 연산자 조합의 방문 여부

    public static void run() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        numbers = new int[N];
        for (int i = 0; i < N; i++)
            numbers[i] = sc.nextInt();

        operator = new int[N - 1];
        visited = new boolean[N - 1];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            int cntOpr = sc.nextInt(); // 연산자의 수

            for (int j = 0; j < cntOpr; j++) { // 연산자의 수 만큼 해당 index를 연산자 조합 배열에 삽입.
                operator[index] = i; // (index 0:+, 1:-, 2:*, 3:/)
                index++;
            }
        }

		dfs(0, 0, numbers[0]);

        System.out.println(maxSum);
        System.out.println(minSum);
    }

    public static void dfs(int start, int depth, int sum) {
        int result = 0;

        if (depth == N - 1) {
//            print(" 단말 노드 도착=>", operator, visited);
            maxSum = Math.max(maxSum, sum);
            minSum = Math.min(minSum, sum);

//			return;
        }

        for (int i = 0; i < N - 1; i++) { // 처음부터 끝까지 반복
            if (visited[i] == false) { // 처음부터 반복했을 때 앞에서 선택하지 않은 것을 선택.
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
                visited[i] = true; // 방문 표시
//                print("새로운 노드 방문-> ", operator, visited);
                dfs(i, depth + 1, result); // 다음 단계 수행. start root는 자기 자신부터 다시 탐색.
            }
        }

        // backtracking
        visited[start] = false;
//        print("부모로 올라감->", operator, visited);
    }

    /* 과정 확인용 출력 함수 */
    public static void print(String str, int[] operator, boolean[] visited) {
        System.out.println(str);
        for (int i = 0; i < operator.length; i++) {
            System.out.print(operator[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == true)
                System.out.print("t ");
            else
                System.out.print("f ");
        }
        System.out.println();
    }
}

