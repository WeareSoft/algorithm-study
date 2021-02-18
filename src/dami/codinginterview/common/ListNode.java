package dami.codinginterview.common;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() { }

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public void add(ListNode node) {
		ListNode current = this;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;
	}
}
