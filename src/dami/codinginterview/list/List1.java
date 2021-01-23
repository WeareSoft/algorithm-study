package dami.codinginterview.list;

public class List1 {
	// 1 2 3 6 7
	public ListNode reverseList(ListNode node) {
		//return mySolutionByIterative(node);
		//return solutionByRecursive(node);
		//return solutionByIterative(node);
		return solutionByRecursive(node);
	}

	// 새로 생성하는 노드(reversed)에게 이전 노드 리스트(current) 이어 붙이기
	private ListNode mySolutionByIterative(ListNode node) {
		ListNode reversed = null;
		ListNode current = null;
		while (null != node) {
			reversed = new ListNode(node.val);
			reversed.next = current;
			current = reversed;
			node = node.next;
		}

		return reversed;
	}


	private ListNode solutionByIterative(ListNode node) {
		ListNode current = node;
		ListNode prev = null;
		ListNode next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}

	private ListNode solutionByRecursive(ListNode node) {
		if (node == null || node.next == null) {
			return node;
		}

		ListNode reversedNode = solutionByRecursive(node.next);
		node.next.next = node;
		node.next = null;

		return reversedNode;
	}

}
