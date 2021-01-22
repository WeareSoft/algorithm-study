package dami.codinginterview.list;

import java.util.HashMap;
import java.util.Map;

public class List2 {
	public ListNode findNthNodeFromEnd(int n, ListNode node) {
		//return mySolution(n, node);
		//return solution1(n, node);
		//return solution2(n, node);
		return solution3(n, node);
	}

	// 시간 : O(n)
	// 공간 : O(1)
	private ListNode mySolution(int n, ListNode node) {
		if (null == node) {
			return null;
		}

		int nodeSize = sizeOf(node);
		for (int i = 0; i < nodeSize - n; i++) {
			node = node.next;
		}
		return node;
	}

	private int sizeOf(ListNode node) {
		ListNode head = node;
		int size = 0;

		while (null != head) {
			size++;
			head = head.next;
		}

		return size;
	}

	// using Map
	// 시간 : O(n)
	// 공간 : O(n)
	private ListNode solution1(int n, ListNode node) {
		Map<Integer, ListNode> nodeMap = new HashMap<>();
		int key = 0;
		while (null != node) {
			nodeMap.put(key++, node);
			node = node.next;
		}

		return nodeMap.get(nodeMap.size() - n);
	}

	// mySolution과 동일한 해결 방법
	// 시간 : O(n)    단, 순회를 두 번
	// 공간 : O(1)
	private ListNode solution2(int n, ListNode node) {
		ListNode current = node;
		int length = 0;
		while (current != null) {
			length++;
			current = current.next;
		}

		ListNode target = node;
		int targetIndex = length - n;
		while (targetIndex > 0) {
			targetIndex--;
			target = target.next;
		}

		return target;
	}

	// left, right 두 개의 포인터를 사용하여 한 번만 순회하는 방법
	// left와 right 사이 간격을 n - 1만큼 주고 right이 끝 노드에 도달했을 때 left가 가리키는 노드를 반환
	// 시간 : O(n)    순회 한 번
	// 공간 : O(1)
	private ListNode solution3(int n, ListNode node) {
		ListNode left = node;
		ListNode right = node;

		int between = 0;
		while (right.next != null) {
			right = right.next;

			if (between < n - 1) {
				between++;
			} else {
				left = left.next;
			}
		}

		return left;
	}
}
