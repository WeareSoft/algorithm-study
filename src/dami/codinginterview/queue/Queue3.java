package dami.codinginterview.queue;

import dami.codinginterview.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Queue3 {
	// 시간 : O(n)
	// 공간 : O(B), B는 트리 한 계층의 최대 너비. 생성하는 큐에는 트리 한 계층의 노드만 들어가기 때문
	public int levelSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

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

	// 시간 : O(n)
	// 공간 : O(B)
	public int solution(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int result = root.val;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int count = queue.size();
			int sum = 0;

			while (count > 0) {
				count--;
				TreeNode node = queue.poll();
				sum += node.val;

				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}

			result = Math.max(result, sum);
		}

		return result;
	}
}
