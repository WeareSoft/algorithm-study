package hee.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal_144 {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            result.add(root.val); // 루트
            preorderTraversal(root.left); // 왼쪽
            preorderTraversal(root.right); // 오른쪽
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
