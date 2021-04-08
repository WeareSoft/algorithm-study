package hackerrank;

import com.sun.corba.se.pept.encoding.InputObject;

public class IsThisABinarySearchTree {
    boolean checkBST(Node root) {
        return isBinarySearchTree(root);
    }

    private boolean isBinarySearchTree(Node node) {
        if (node.left == null) {
            return node.right == null;
        } else {
            if (node.right == null) {
                return false;
            } else {
                return (node.left.data < node.data && node.data < node.right.data) && (isBinarySearchTree(node.left) && isBinarySearchTree(node.right));
            }
        }
    }

    class Node {
        int data;
        Node left;
        Node right;
    }
}
