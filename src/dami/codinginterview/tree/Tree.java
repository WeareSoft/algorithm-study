package dami.codinginterview.tree;


import com.sun.corba.se.impl.orbutil.StackImpl;
import dami.codinginterview.common.TreeNode;

import java.util.Stack;

public class Tree {
	public void inorderIterating(TreeNode node) {
		if (node == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		while (true) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			if (stack.isEmpty()) {
				break;
			}

			node = stack.pop();
			System.out.println(node.val);
			node = node.right;
		}
	}

	public void inorderRecursive(TreeNode node) {
		if (node == null) {
			return;
		}

		inorderRecursive(node.left);
		System.out.println(node.val);
		inorderRecursive(node.right);
	}
}
