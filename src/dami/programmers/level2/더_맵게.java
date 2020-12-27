package dami.programmers.level2;

import java.util.PriorityQueue;

// https://programmers.co.kr/learn/courses/30/lessons/42626
// 처음엔 앞에서부터 합치도록 구현함
// 테스트 케이스 실패
// 반례 케이스 : [1, 1, 1, 1, 3]
//  1회 합치면 [3, 1, 1, 3]이 되고, 가장 작은 + 그 다음 작은 수를 찾아야 하는데 정렬이 되어있지 않으니 앞에서부터 3, 1로 합치게 됨

// 우선순위 큐 사용하도록 수정
// 큐의 각 값에 우선순위가 정해져있으며 힙을 이용해 구현
// 힙 : 완전 이진 트리의 일종으로 **여러 값 중 최대/최솟값을 빨리 찾기** 위한 자료구조 (중복 허용)
//  최소 힙은 우선순위가 오름차순 정렬, 최대 힙은 우선순위가 내림차순 정렬
// 힙 자료구조 : https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html
// 자바의 PriorityQueue 사용 : https://coding-factory.tistory.com/603

public class 더_맵게 {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> scovilleQ = new PriorityQueue<>();
		for (int scov : scoville) {
			scovilleQ.add(scov);
		}

		int count = 0;
		int min;
		while (scovilleQ.size() > 1) {
			min = scovilleQ.poll();
			if (min >= K) {
				break;
			}

			min += scovilleQ.poll() * 2;
			scovilleQ.add(min);
			count++;
		}

		return scovilleQ.poll() >= K ? count : -1;
	}
}
