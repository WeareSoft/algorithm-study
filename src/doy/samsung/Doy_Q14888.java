package doy.samsung;

import java.util.Scanner;

/* [연산자 끼워넣기] https://www.acmicpc.net/problem/14888
    첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)
    둘째 줄에는 A1, A2, ..., AN(1 ≤ Ai ≤ 100)
    셋째 줄에는 합이 N-1인 4개의 정수, 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수
    N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것 출력 */
public class Doy_Q14888 {
    static Scanner s = new Scanner(System.in);
    static int[] nums, numOfOperator, operators;
    static boolean[] selected;
    static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static final int ADD = 0, SUB = 1, MUL = 2, DIV = 3;

    public static void run() {
        n = s.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }

        numOfOperator = new int[4]; // 연산자의 개수 입력받음
        operators = new int[n - 1]; // 입력한 개수만큼 연산자 저장(+ : 0, - : 1, * : 2, / : 3)(수를 n개 입력받았으므로 연산자의 개수는 n-1)
        selected = new boolean[n - 1]; // 탐색 시 연산자 선택 여부
        int operatorIndex = 0;
        for (int i = 0; i < 4; i++) {
            int input = s.nextInt();
            numOfOperator[i] = input;
            for (int j = 0; j < input; j++) {
                operators[operatorIndex++] = i;
            }
        }

        // 연산자 조합 완전탐색
        dfs(0, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    // 1. 입력받은 개수로 operators 배열을 만들어 탐색 (배열을 만드는 시간때문에 그렇지 않을 때보다 시간은 두 배 더 걸림, 하지만 더 직관적)
    static private void dfs(int count, int value) {
        // 모든 연산자를 선택했으면
        if (count == n - 1) {
            max = Math.max(value, max);
            min = Math.min(value, min);
            return;
        }

        // operators 배열에서 index 상으로 뒤에 위치한 연산자를 먼저 선택 후 앞에 위치한 연산자를 나중에 선택할 수 있으므로 항상 0부터 순회
        for (int i = 0; i < operators.length; i++) {
            // 이미 선택된 연산자라면 다음 순회
            if (selected[i]) continue;

            // i번째 연산자 선택
            selected[i] = true;
            switch (operators[i]) {
                case ADD: // 지금 값과 다음 수와 덧셈
                    dfs(count + 1, value + nums[count + 1]);
                    break;
                case SUB: // 다음 수와 뺄셈
                    dfs(count + 1, value - nums[count + 1]);
                    break;
                case MUL: // 다음 수와 곱셈
                    dfs(count + 1, value * nums[count + 1]);
                    break;
                case DIV: // 다음 수와 나눗셈
                    dfs(count + 1, value / nums[count + 1]);
                    break;
            }
            // backtracking
            selected[i] = false;
        }
    }
}

//    // 2. 처음에 입력받은 numOfOperator 로 탐색
//    static private void dfs(int count, int value) {
//        // 모든 연산자를 선택했으면 (수를 n개 입력받았으므로 연산자의 개수는 n-1)
//        if (count == n - 1) {
//            max = Math.max(value, max);
//            min = Math.min(value, min);
//            return;
//        }
//
//        for (int i = 0; i < numOfOperator.length; i++) {
//            // 연산자의 개수가 0보다 크면
//            if (numOfOperator[i] > 0) {
//                numOfOperator[i]--;
//
//                switch (i) {
//                    case ADD: // 다음 수와 덧셈
//                        dfs(count + 1, value + nums[count + 1]);
//                        break;
//                    case SUB: // 다음 수와 뺄셈
//                        dfs(count + 1, value - nums[count + 1]);
//                        break;
//                    case MUL: // 다음 수와 곱셈
//                        dfs(count + 1, value * nums[count + 1]);
//                        break;
//                    case DIV: // 다음 수와 나눗셈
//                        dfs(count + 1, value / nums[count + 1]);
//                        break;
//                }
//
//                // backtracking
//                numOfOperator[i]++;
//            }
//        }
//    }