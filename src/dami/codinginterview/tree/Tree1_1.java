package dami.codinginterview.tree;

import dami.codinginterview.common.TreeNode;

public class Tree1_1 {
	public void findTreeDepth(TreeNode node) {

	}

	private int solution(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftDepth = solution(node.left);
		int rightDepth = solution(node.right);

		if (leftDepth > rightDepth) {
			return leftDepth + 1;
		} else {
			return rightDepth + 1;
		}
	}
}
