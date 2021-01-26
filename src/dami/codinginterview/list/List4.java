package dami.codinginterview.list;

import java.util.HashSet;
import java.util.Set;

public class List4 {
	public boolean circleOrNot(ListNode node) {
		return mySolution(node);
	}

	// 시간 : O(n)
	// 공간 : O(1) ~ O(n)
	private boolean mySolution(ListNode node) {
		ListNode current = node;

		Set<Integer> nodeSet = new HashSet<>();
		while (current != null) {
			if (nodeSet.contains(current.val)) {
				return true;
			}
			nodeSet.add(current.val);
			current = current.next;
		}

		return false;
	}

	private boolean solution(ListNode node) {
		return false;
	}
}
