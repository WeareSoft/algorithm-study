package dami.codinginterview.queue;

import java.util.LinkedList;
import java.util.Queue;

// queue의 연산 offer(), poll(), isEmpty()만 사용 가능
public class Queue1 {
	public Queue<Integer> reverseQueue(Queue<Integer> queue) {
		//return mySolutionByIterating(queue);
		return mySolutionByRecursive(queue);
	}

	// 시간 : O(n^2)
	// 공간 : O(n)? O(n^2)?
	// 비효율적인듯..
	private Queue<Integer> mySolutionByIterating(Queue<Integer> queue) {
		Queue<Integer> reversedQueue = new LinkedList<>();
		Queue<Integer> tempQueue = new LinkedList<>();

		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (reversedQueue.isEmpty()) {
				reversedQueue.offer(current);
			} else {
				while (!reversedQueue.isEmpty()) {
					tempQueue.offer(reversedQueue.poll());
				}
				reversedQueue.offer(current);
				while (!tempQueue.isEmpty()) {
					reversedQueue.offer(tempQueue.poll());
				}
			}
		}

		return reversedQueue;
	}

	// 시간 : O(n)
	// 공간 : O(n)
	private Queue<Integer> mySolutionByRecursive(Queue<Integer> queue) {
		recursive(queue);
		return queue;
	}

	private void recursive(Queue<Integer> queue) {
		if (queue.isEmpty()) {
			return;
		}

		int temp = queue.poll();
		recursive(queue);
		queue.offer(temp);
	}

	private Queue<Integer> solution(Queue<Integer> queue) {
		return null;
	}
}
