package dami.leetcode.medium;

public class Add_Two_Numbers_2 {
	public Add_Two_Numbers_2() {
		// TestCase 1
		ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
		ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

		// TestCase 2
		//ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		//ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

		// TestCase 3
		//ListNode l1 = new ListNode(0);
		//ListNode l2 = new ListNode(0);

		ListNode result = addTwoNumbers(l1, l2);
		while (null != result) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode((l1.val + l2.val) % 10);
		ListNode newNode = result;
		int carry = (l1.val + l2.val) / 10;
		while (null != l1.next || null != l2.next) {
			int first = 0, second = 0;
			if (null != l1.next) {
				l1 = l1.next;
				first = l1.val;
			}
			if (null != l2.next) {
				l2 = l2.next;
				second = l2.val;
			}

			int sum = first + second + carry;
			newNode = newNode.next = new ListNode(sum % 10);

			carry = sum / 10;
		}

		if (carry > 0) {
			newNode.next = new ListNode(1);
		}

		return result;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() { }

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
