package dami.codinginterview.list;

import dami.codinginterview.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class List4 {
	public boolean circleOrNot(ListNode node) {
		//return mySolution(node);
		return solution3(node);
	}

	// 시간 : O(n)
	// 공간 : O(1) ~ O(n)
	private boolean mySolution(ListNode node) {
		ListNode current = node;

		Set<ListNode> nodeSet = new HashSet<>();
		while (current != null) {
			if (nodeSet.contains(current)) {
				return true;
			}
			nodeSet.add(current);
			current = current.next;
		}

		return false;
	}

	// 가장 단순한 방법
	// 하지만 솔루션이 될 수 없음
	private boolean solution1(ListNode node) {
		// 노드를 순회하면서 현재 노드가 다음 노드 중에 중복으로 나타나는지 확인하는 방법
		// 1 -> 2 -> 3 -> 4 -> 3 이라면 3과 4에서 무한루프에 빠질 수 있기 때문
		return false;
	}

	// mySolution과 동일한 방법 (node로 비교)
	private boolean solution2(ListNode node) {
		return false;
	}

	// 시간 : O(n)
	// 공간 : O(1)
	// 플로이드 알고리즘?
	// 원 위를 순환하는 두 점의 속도가 다를 때 두 점은 언젠가는 반드시 만나게 되어있는 특징을 이용
	private boolean solution3(ListNode node) {
		ListNode slow = node;
		ListNode fast = node;
		while (slow != null && fast != null) {
			if (fast.next == null || fast.next.next == null) {
				return false;
			}

			fast = fast.next.next;
			if (slow.equals(fast)) {
				return true;
			}
			slow = slow.next;
		}

		return false;
	}
}
