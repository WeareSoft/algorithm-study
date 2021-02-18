package dami.codinginterview.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queue4 {
	public void implementStackByQueue() {
		StackByQueue stack = new StackByQueue();
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

class StackByQueue {
	private final Queue<Integer> queue;

	public StackByQueue() {
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
