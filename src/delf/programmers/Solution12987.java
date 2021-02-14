package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 숫자 게임
 * https://programmers.co.kr/learn/courses/30/lessons/12987
 **/
public class Solution12987 {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        Queue<Integer> qA = new LinkedList<>(new ArrayList<>(Arrays.asList(Arrays.stream(A).boxed().toArray(Integer[]::new))));
        Queue<Integer> qB = new LinkedList<>(new ArrayList<>(Arrays.asList(Arrays.stream(B).boxed().toArray(Integer[]::new))));

        int answer = 0;
        while (!qA.isEmpty() && !qB.isEmpty()) {
            if (qA.peek() < qB.peek()) {
                qA.poll();
                answer++;
            }
            qB.poll();
        }
        return answer;
    }
}
