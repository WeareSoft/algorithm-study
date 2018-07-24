package doy.tree;

import java.util.Scanner;

public class Doy_Q1991 {
    static Scanner s = new Scanner(System.in);
    static int[][] tree = new int[26][2];

    private static void preOrder(int data) {
        if (data == -1) return;

        System.out.print((char) (data + 'A'));
        preOrder(tree[data][0]);
        preOrder(tree[data][1]);
    }

    private static void inOrder(int data) {
        if (data == -1) return;

        inOrder(tree[data][0]);
        System.out.print((char) (data + 'A'));
        inOrder(tree[data][1]);
    }

    private static void postOrder(int data) {
        if (data == -1) return;

        postOrder(tree[data][0]);
        postOrder(tree[data][1]);
        System.out.print((char) (data + 'A'));
    }

    public static void run() {
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int rootNode = s.next().charAt(0) - 'A';

            char leftChildNode = s.next().charAt(0);
            if (leftChildNode == '.')
                tree[rootNode][0] = -1;
            else
                tree[rootNode][0] = leftChildNode - 'A';

            char rightChildNode = s.next().charAt(0);
            if (rightChildNode == '.')
                tree[rootNode][1] = -1;
            else
                tree[rootNode][1] = rightChildNode - 'A';
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
}

/*
    풀이가 동일하네요 :)
    트리의 개념에 대해 같이 정리해보면 좋을 거 같아요.
*/
