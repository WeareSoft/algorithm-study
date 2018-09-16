package hee.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hee_Q2805 {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int N = scanner.nextInt(); // 나무의 수(1 ≤ N ≤ 1,000,000)
        int M = scanner.nextInt(); // 집으로 가져가려고 하는 나무 길이(1 ≤ M ≤ 2,000,000,000)

        // 나무의 높이 (1,000,000,000보다 작거나 같은 양의 정수 또는 0)
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (N-- > 0) {
            arrayList.add(scanner.nextInt());
        }
        Collections.sort(arrayList);

        /* 이진 탐색을 이용 */
        long min = 1;
        long max = arrayList.get(arrayList.size()-1); // 왜 long이어야 될까..??
        while (min <= max) { // 만족하는 최댓값
            long mid = (min + max) / 2;
            long sumSize = sumOfTruncatedTrees(arrayList, mid);

            // 처음에는 ==이 되면 break를 걸어서 시간을 단축해보려고 했는데, 그건 구체적인 수를 찾을 때는 가능하지만,
            // 문제처럼 가능한 경우의 수 중에서 최대값을 구할 경우에는 다음과 같은 부등호 처리를 해야한다.
            // == 이 아니라도 문제에 답이 되는 경우가 존재하기 때문이다.
            if (sumSize >= M) { // 잘린 나무 길이의 합이 M보다 작거나 같으면
                min = mid + 1; // min을 키운다.
            } else {
                max = mid - 1;
            }
        }
        System.out.println(max);
    }

    /* 잘린 나무 길이의 합 */
    static long sumOfTruncatedTrees(ArrayList<Integer> arrayList, long cutSize) {
        long res = 0;

        for(int i=0; i<arrayList.size(); i++) {
            long cut = arrayList.get(i) - cutSize;
            if (cut > 0){
                res += cut;
            }
        }
        return res;
    }
}

// reference: http://zorba91.tistory.com/entry/1654-1

