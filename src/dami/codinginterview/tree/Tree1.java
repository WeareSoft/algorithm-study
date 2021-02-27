package dami.codinginterview.tree;

import dami.codinginterview.common.TreeNode;

public class Tree1 {
	public void findNthNode(TreeNode root, int n) {
		mySolution(root, n - 1);
		solution(root, n - 1);
	}

	private int mySolution(TreeNode node, int n) {
		if (node == null) {
			return n + 1;
		}

		if (n < 0) {
			return n;
		}

		if (n == 0) {
			System.out.println(node.val);
		}

		n = mySolution(node.left, --n);
		n = mySolution(node.right, --n);

		return n;
	}

	private int count = 0;
	private void solution(TreeNode node, int n) {
		if (node == null) {
			return;
		}

		solution(node.left, n);
		solution(node.right, n);

		if (count++ == n) {
			System.out.println(node.val);
		}
	}

}
