package hee.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal_145 {
    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left); // 왼쪽
            postorderTraversal(root.right); // 오른쪽
            result.add(root.val); // 루트
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
