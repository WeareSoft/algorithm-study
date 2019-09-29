package hee.leetcode;

import java.util.ArrayList;
import java.util.List;

// 중위(in-order) 탐색 : 왼쪽 자식 노드, 내 노드, 오른쪽 자식노드 순서로 방문
public class InorderTraversal_94 {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        /* 중위 순회 */
        if(root != null) {
            inorderTraversal(root.left); // 왼쪽
            result.add(root.val); // 루트
            inorderTraversal(root.right); // 오른쪽
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
