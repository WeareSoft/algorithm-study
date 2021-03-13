package programmers;

import java.util.*;

/**
 * 길 찾기 게임
 * https://programmers.co.kr/learn/courses/30/lessons/42892
 */
public class Solution42892 {
    static int X = 0;
    static int Y = 1;

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}})));
    }

    public static int[][] solution(int[][] nodeinfo) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            Node node = new Node(i + 1, nodeinfo[i][X], nodeinfo[i][Y]);
            nodeList.add(node);
        }

        Collections.sort(nodeList);
        System.out.println(nodeList);

        Node parent = nodeList.get(0);
        Node head = parent;
        Node grandParent;
        Node firstNodeAtLevel = head;
        for (int i = 1; i < nodeinfo.length; i++) {
            Node node = nodeList.get(i);
            if (firstNodeAtLevel.y != node.y) {
                parent = firstNodeAtLevel;
                firstNodeAtLevel = node;
            }

            // 왼쪽의 왼쪽
            if (node.x < parent.x) {
                parent.left = node;
                node.parent = parent;
                continue;
            }

            // 왼쪽의 오른쪽
            grandParent = parent.parent;
            if (grandParent == null || node.x < grandParent.x) {
                parent.right = node;
                node.parent = parent;
                continue;
            }

            Node sibling = grandParent.right;
            if (node.x < sibling.x) { // 오른쪽의 왼쪽
                sibling.left = node;
            } else { // 오른쪽의 오른쪽
                sibling.right = node;
            }
            node.parent = sibling;
        }
        printPreOrder(head);
        return new int[1][1];
    }

    static void printPreOrder(Node node) {
        System.out.println(node.value);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    static void printPostOrder(Node node) {
        printPreOrder(node.left);
        System.out.println(node.value);
        printPreOrder(node.right);
    }

    static class Node implements Comparable<Node> {
        int value;
        int x;
        int y;
        Node parent;
        Node left;
        Node right;

        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", x=" + x +
                    ", y=" + y +
                    ", left.v=" + (left == null ? "null" : left.value) +
                    ", right.v=" + (right == null ? "null" : right.value) +
                    "}\n";
        }

        @Override
        public int compareTo(Node o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }
            return o.y - this.y;
        }
    }
}
