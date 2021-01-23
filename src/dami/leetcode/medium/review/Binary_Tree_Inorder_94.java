package dami.leetcode.medium.review;

import dami.leetcode.common.TreeNode;

import java.util.*;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class Binary_Tree_Inorder_94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5, new TreeNode(7), new TreeNode(8)));
		List<Integer> result = new ArrayList<>();

		// 1. 순환 방법
		recursive(root, result);
		// 2. 반복 방법
		iteration(root, result);

		return result;
	}

	private void recursive(TreeNode node, List<Integer> result) {
		if (null == node) {
			return;
		}
		recursive(node.left, result);
		result.add(node.val);
		recursive(node.right, result);
	}

	private void iteration(TreeNode node, List<Integer> result) {
		if (null == node) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = node;
		while (null != current || !stack.isEmpty()) {
			while (null != current) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			result.add(current.val);
			current = current.right;
		}
	}

}
