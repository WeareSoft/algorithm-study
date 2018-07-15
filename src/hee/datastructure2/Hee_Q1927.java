package hee.datastructure2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// 최소힙 구현
public class Hee_Q1927 {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        /* 최소힙 구현 */
        // 우선순위 큐의 기본: 최소힙
        // o1>o2: 1, o1==o2: 0, o1<o2: -1, 작은 값이 우선순위(오름차순)가 높다.
        PriorityQueue<Integer> q = new PriorityQueue<>();

        /* 최대힙 구현 */
        // Comparator 인터페이스 재정의
        // o1>o2: -1, o1==o2: 0, o1<o2: 1, 큰 값이 우선순위(내림차순)가 높다.
//        PriorityQueue<Integer> q = new PriorityQueue<>(1, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1); // return o2 - o1와 동일
//            }
//        });


        int N = scanner.nextInt();
        while (N-- > 0) {
            int x = scanner.nextInt();

            if (x == 0) {
                if (q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(q.poll());
                }
            } else {
                q.offer(x);
            }
        }
    }
}
