package dami.leetcode.medium;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// 다른 코드 : https://leetcode.com/submissions/detail/431959305/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Remove_Nth_Node_19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		// head = new ListNode(1);

		int listSize = sizeOf(head);
		ListNode current = head;
		if (n == listSize) { // 첫번째 노드일 때
			head = current.next;

		} else if (n == 1) { // 마지막 노드일 때
			for (int i = 0; i < listSize - 2; i++) {
				current = current.next;
			}
			current.next = null;

		} else { // 중간 노드
			for (int i = 0; i < listSize - n - 1; i++) {
				current = current.next;
			}
			current.next = current.next.next;
		}

		return head;
	}

	private int sizeOf(ListNode head) {
		int size = 0;
		ListNode list = head;
		while (list != null) {
			list = list.next;
			size++;
		}
		return size;
	}
}
