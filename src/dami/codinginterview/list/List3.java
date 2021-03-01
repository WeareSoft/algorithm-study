package dami.codinginterview.list;

import dami.codinginterview.common.ListNode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class List3 {
	public ListNode distinct(ListNode node) {
		//return mySolution(node);
		//return solution1(node);
		//return solution2(node);
		return solution3(node);
		//return solution4(node);
	}

	// 시간 : O(n)    단, 순회 두 번
	// 공간 : O(n)
	private ListNode mySolution(ListNode node) {
		Set<Integer> set = new LinkedHashSet<>();
		while (null != node) {
			set.add(node.val);
			node = node.next;
		}

		ListNode head = null;
		ListNode current = null;
		for (Integer number : set) {
			ListNode newNode = new ListNode(number);

			if (null == current) {
				current = newNode;
				head = current;
			} else {
				current.next = newNode;
				current = current.next;
			}
		}

		return head;
	}

	// 시간 : O(n)
	// 공간 : O(1)
	private ListNode solution1(ListNode node) {
		ListNode current = node;

		while (current != null) {
			ListNode temp = current;
			while (temp != null && current.val == temp.val) {
				temp = temp.next;
			}

			current.next = temp;
			current = current.next;
		}

		return node;
	}

	// prev와 current를 두고 한 노드 씩 이동 하면서 값 비교
	// 만약 prev 노드 값과 current 노드 값이 같다면 current만 다음 노드로 이동
	// 두 노드 값이 달라졌을 때 prev의 next를 current로 변경
	// 시간 : O(n)
	// 공간 : O(1)
	private ListNode solution2(ListNode node) {
		ListNode current = node;
		ListNode prev = node;

		while (current != null) {
			if(prev.val != current.val) {
				prev.next = current;
				prev = current;
			}
			current = current.next;

			if (current == null) {
				prev.next = null;
			}
		}
		return node;
	}

	// recursive
	// 시간 : O(n)
	// 공간 : O(n)
	private ListNode solution3(ListNode node) {
		recursive(node);
		return node;
	}

	private void recursive(ListNode node) {
		if (node == null) {
			return;
		}

		if (node.next != null) {
			if (node.val == node.next.val) {
				node.next = node.next.next;
				recursive(node);
			} else {
				recursive(node.next);
			}
		}
	}

	// using Set
	// mySolution에서 순회 1번으로 축소
	// 시간 : O(n)
	// 공간 : O(n)
	private ListNode solution4(ListNode node) {
		Set<Integer> set = new HashSet<>();
		ListNode current = node;
		ListNode prev = null;

		while (current != null) {
			if (set.contains(current.val)) { // 중복
				prev.next = current.next;
			} else {
				set.add(current.val);
				prev = current;
			}

			current = current.next;
		}
		return node;
	}
}
