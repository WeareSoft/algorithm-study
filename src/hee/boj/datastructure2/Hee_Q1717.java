package hee.boj.datastructure2;

import java.util.Scanner;

public class Hee_Q1717 {
    static Scanner scanner = new Scanner(System.in);
    static int[] arrays;

    static int find(int x) {
        /* 1. 반복문 이용 */
//        while (x != arrays[x]) {
//            x = arrays[x];
//        }
//        return x;

        /* 2. 재귀함수 이용 */
        if (x == arrays[x]) {
            return x;
        } else {
//            // 문제: 시간 복잡도가 O(N)이 될 수 있다.
//            return find(arrays[x]);

            // 해결: 경로 압축 이용
            // find 하면서 만난 모든 값의 parent를 루트로 바꿔준다.
            return arrays[x] = find(arrays[x]);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        arrays[y] = x;
    }

    public static void run() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // arrays[i] = i 초기화
        arrays = new int[n + 1];
        for (int i=1; i<=n; i++){
            arrays[i] = i;
        }

        while (m > 0) {
            int check = scanner.nextInt();

            // 합집합
            if (check == 0) {
                union(scanner.nextInt(), scanner.nextInt());
            }
            // 두 원소가 같은 집합에 포함되어 있는지 확인
            else {
                int x = find(scanner.nextInt());
                int y = find(scanner.nextInt());

                if (x == y) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

            m--;
        }
    }
}
