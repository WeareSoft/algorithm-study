package dami.codinginterview.tree;

import dami.codinginterview.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

// 1. 전위 배열의 첫번째 값은 트리의 루트 노드 값
// 2. 중위 배열에서 루트 노드 값 위치 찾고, 해당 값 기준 왼쪽은 왼쪽 하위 노드, 오른쪽은 오른쪽 하위 노드
// 3. 중위 배열 좌, 우 분리해서 재귀 반복
// 4. 재귀 탈출 조건 : 잘라낸 중위 배열의 start 인덱스와 end 인덱스가 같으면 리프 노드 / start 인덱스 > end 인덱스면 null
public class Tree2 {
	private int preIndex = 0;

	// 시간 : O(n^2)
	// 공간 : O(n)
	public TreeNode makeBinaryTree(int[] inorder, int[] preorder) {
		return myRecursive(preorder, inorder, 0, inorder.length - 1);
	}

	private TreeNode myRecursive(int[] preorder, int[] inorder, int start, int end) {
		if (start == end) {
			return new TreeNode(inorder[start]);
		}

		if (start > end) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[preIndex++]);
		int inIndex = searchInIndex(inorder, node.val);

		node.left = myRecursive(preorder, inorder, start, inIndex - 1);
		node.right = myRecursive(preorder, inorder, inIndex + 1, end);

		return node;
	}

	private int searchInIndex(int[] inorder, int value) {
		int inIndex = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == value) {
				inIndex = i;
			}
		}
		return inIndex;
	}


	// 시간 : O(n)
	// 공간 : O(n)
	private Map<Integer, Integer> inorderMap = new HashMap<>();
	public TreeNode makeBinaryTree_최적화(int[] inorder, int[] preorder) {
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}

		return recursive(preorder, 0, inorder.length - 1);
	}

	private TreeNode recursive(int[] preorder, int start, int end) {
		if (start > end) {
			return null;
		}

		TreeNode node = new TreeNode(preorder[preIndex++]);

		if (start == end) {
			return node;
		}

		int inIndex = inorderMap.get(node.val);

		node.left = recursive(preorder, start, inIndex - 1);
		node.right = recursive(preorder, inIndex + 1, end);

		return node;
	}
}
