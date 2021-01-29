package dami.codinginterview;

import dami.codinginterview.list.ListNode;

public class Interview {
	public void solutions() {
		//new Array3().twoSum(new int[] {2, 3, 4, 7, 8, 9}, 12);
		//new Array4().sorting(new int[]{10, 5, 8, 7, 3, 9});

		//new List1().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(6, new ListNode(7))))));
		//new List2().findNthNodeFromEnd(2, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(6, new ListNode(7))))));
		//new List3().distinct(new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(4)))))));
		//new List4().circleOrNot(circleNode());

		//new Stack1().reverse(stack);
	}

	private ListNode circleNode() {
		ListNode three = new ListNode(3);
		ListNode node = new ListNode(1, new ListNode(2));
		node.add(three);
		node.add(new ListNode(4, new ListNode(5)));
		node.add(three);
		return node;
	}
}
