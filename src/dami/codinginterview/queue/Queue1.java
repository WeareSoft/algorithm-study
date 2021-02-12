package dami.codinginterview.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// queue의 연산 offer(), poll(), isEmpty()만 사용 가능
public class Queue1 {
	public Queue<Integer> reverseQueue(Queue<Integer> queue) {
		//return mySolutionByIterating(queue);
		return mySolutionByRecursive(queue);
	}

	// 시간 : O(n^2)
	// 공간 : O(n)? O(n^2)?
	// 비효율적인듯.. => 큐만 써야 하는 줄 알았는데 강의 보니 스택 써서 간단하게 해결했다. ^_ㅠ
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

	private Queue<Integer> solution1(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
		return queue;
	}

	private Queue<Integer> solution2(Queue<Integer> queue) {
		if (queue.isEmpty()) {
			return queue;
		}

		int front = queue.poll();
		queue = solution2(queue);
		queue.offer(front);

		return queue;
	}
}
