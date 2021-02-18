package dami.codinginterview.queue;

import dami.codinginterview.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Queue3 {
	public int levelSum(TreeNode root) {
		Queue<TreeNode> nodes = new LinkedList<>();

		nodes.offer(root);

		int max = root.val;
		int sum = 0;
		int levelSize = nodes.size();
		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			levelSize--;

			sum += node.val;

			if (node.left != null) nodes.offer(node.left);
			if (node.right != null) nodes.offer(node.right);

			if (levelSize == 0) {
				max = Math.max(sum, max);
				sum = 0;
				levelSize = nodes.size();
			}
		}

		return max;
	}
}
