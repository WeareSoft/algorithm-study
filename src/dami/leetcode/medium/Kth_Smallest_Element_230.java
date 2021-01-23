package dami.leetcode.medium;

import dami.leetcode.common.TreeNode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// 1. 트리노드 순회하며 값 모두 꺼내서 우선순위 큐에 추가
// 2. k만큼 우선순위 큐에서 빼기
public class Kth_Smallest_Element_230 {

	// 시간 : O(n)
	// 공간 : O(n)? O(n^2)?
	public int kthSmallest(TreeNode root, int k) {
		PriorityQueue<Integer> tree = new PriorityQueue<>();

		inorder(tree, root);

		int result = 0;
		while (!tree.isEmpty() && k-- > 0) {
			result = tree.poll();
		}

		return result;
	}

	private void inorder(PriorityQueue<Integer> tree, TreeNode node) {
		if (null == node) {
			return;
		}

		inorder(tree, node.left);
		tree.offer(node.val);
		inorder(tree, node.right);
	}

}

/*  // 다른 방법
	// 중위순회랑 동시에 k번째 값 확인 가능
	// 이진탐색 트리는 중위순회 순서상 가장 먼저 조회하는 값이 가장 작은 값
	// 조회 순서 == 노드 값 오름차순

public class Kth_Smallest_Element_230 {
    int count = 0, val;

    public int kthSmallest(TreeNode root, int k) {
        visit(root, k);
        return val;
    }


    // in order visit
    private void visit(TreeNode root, int k)  {
        if(root == null || val > 0) {
            return;
        }

        visit(root.left, k);

        if(++count == k) {
            val = root.val;
        }

        visit(root.right, k);
    }
}
*/
