package dami.codinginterview.queue;

import java.util.LinkedList;
import java.util.Queue;

// 두 가지 방법으로 풀이 가능
// 1. 넣을 때 O(n), 꺼낼 때 O(1)인 방법
// 2. 넣을 때 O(1), 꺼낼 때 O(n)인 방법
// 둘 중 어떤 방법으로 풀 지 물어보기
public class Queue4 {
	public void implementStackByQueue() {
		MyQueueStack stack = new MyQueueStack();
		stack.push(3);
		stack.push(4);
		stack.push(10);
		stack.push(5);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}

// 넣을 때 O(n), 꺼낼 때 O(1)인 방법 사용
class MyQueueStack {
	private final Queue<Integer> queue;

	public MyQueueStack() {
		this.queue = new LinkedList<>();
	}

	public void push(int value) {
		if (queue.isEmpty()) {
			queue.offer(value);
			return;
		}

		Queue<Integer> temp = new LinkedList<>();

		while (!queue.isEmpty()) {
			temp.offer(queue.poll());
		}

		queue.offer(value);

		// 반복을 한 번 더 하는 대신 한쪽으로 몰아놓고 queue와 temp를 치환하여 사용하는 방법도 가능 (솔루션 참고)
		while (!temp.isEmpty()) {
			queue.offer(temp.poll());
		}
	}

	public int pop() {
		if (queue.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return queue.poll();
	}
}

// 솔루션 1
// 넣을 때 O(n), 꺼낼 때 O(1)인 방법
class QueueStack1 {
	Queue<Integer> main = new LinkedList<>();
	Queue<Integer> sub = new LinkedList<>();

	public void push(int value) {
		sub.offer(value);
		while (!main.isEmpty()) {
			sub.offer(main.poll());
		}

		Queue<Integer> temp = main;
		main = sub;
		sub = temp;
	}

	public int pop() {
		if (main.isEmpty()) {
			throw new IllegalArgumentException();
		}

		return main.poll();
	}
}

// 솔루션 2
// 넣을 때 O(1), 꺼낼 때 O(n)인 방법
class QueueStack2 {
	Queue<Integer> main = new LinkedList<>();
	Queue<Integer> sub = new LinkedList<>();

	public void push(int value) {
		main.offer(value);
	}

	public int pop() {
		if (main.isEmpty()) {
			throw new IllegalArgumentException();
		}

		// 마지막 한 개만 빼고 옮기기
		while (main.size() > 1) {
			sub.offer(main.poll());
		}

		int result = main.poll();

		Queue<Integer> temp = main;
		main = sub;
		sub = temp;

		return result;
	}
}
