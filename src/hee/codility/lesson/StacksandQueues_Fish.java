package hee.codility.lesson;

import java.util.Stack;

// https://app.codility.com/demo/results/trainingHJBT6G-52A/
// 다른 방법 참고: https://app.codility.com/demo/results/trainingFGC284-U39/
public class StacksandQueues_Fish {
    public int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            // UP
            if (B[i] == 0) {
                // 스택이 비어 있지 않고, 이전의 물고기의 방향이 0이 나올 때까지
                while (!stack.isEmpty() && B[stack.peek()] == 1) {
                    // 이전의 물고기의 방향이 1이면 누군가는 잡아먹힌다.
                    if (A[stack.peek()] < A[i]) { // 이김.
                        stack.pop();
                    } else { // 짐.
                        break; // 변경이 없으니, while 문 끝.
                    }
                } // while 문 끝.

                // 스택이 비어있거나(처음 물고기 또는 모두 잡아먹은 경우), 이전의 물고기의 방향이 0이면
                if (stack.isEmpty() || B[stack.peek()] == 0) {
                    stack.add(i); // 이긴 물고기를 넣는다. 졌으면 그냥 넘어감.
                }
            }
            // DOWN
            else if (B[i] == 1) {
                stack.add(i);
            }
        }
        // System.out.println(stack.size());
        return stack.size();
    }
}
