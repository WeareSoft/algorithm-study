package hee.boj.tree;

import java.util.Scanner;

public class Hee_Q1991 {
    static Scanner scanner = new Scanner(System.in);
    static int[][] binaryTree = new int[26][2];

    /* 전위 순회 */
    public static void preOrder(int data){
        if(data == (int)('.' - 'A')) return; // .이면 자식이 없다.

        System.out.print((char)(data + 'A')); // 루트 노드
        preOrder(binaryTree[data][0]); // 왼쪽 노드
        preOrder(binaryTree[data][1]); // 오른쪽 노드
    }

    /* 중위 순회 */
    public static void inOrder(int data){
        if(data == (int)('.' - 'A')) return; // .이면 자식이 없다.

        inOrder(binaryTree[data][0]); // 왼쪽 노드
        System.out.print((char)(data + 'A')); // 루트 노드
        inOrder(binaryTree[data][1]); // 오른쪽 노드
    }

    /* 후위 순회 */
    public static void postOrder(int data){
        if(data == (int)('.' - 'A')) return; // .이면 자식이 없다.

        postOrder(binaryTree[data][0]); // 왼쪽 노드
        postOrder(binaryTree[data][1]); // 오른쪽 노드
        System.out.print((char)(data + 'A')); // 루트 노드
    }


    public static void run() {
        int N = scanner.nextInt(); // 이진 트리의 노드의 개수
        while (N-- > 0) {
            String root = scanner.next();
            int data = root.charAt(0);
            // 'A' : 65, root를 배열 0에 할당
            binaryTree[data - 'A'][0] = scanner.next().charAt(0) - 'A';
            binaryTree[data - 'A'][1] = scanner.next().charAt(0) - 'A';
        }

        preOrder(0); System.out.println();
        inOrder(0); System.out.println();
        postOrder(0); System.out.println();
    }
}

/*
    풀이가 동일하네요
    이진 트리 탐색의 종류와 구현 방법에 대해 정리해보는 시간이였어요 :)
    전위(pre-order) 탐색 : 내 노드, 왼쪽 자식 노드, 오른쪽 자식 노드 순서로 방문
    후위(post-order) 탐색 : 왼쪽 자식 노드, 오른쪽 자식 노드, 내 노드 순서로 방문
    중위(in-order) 탐색 : 왼쪽 자식 노드, 내 노드, 오른쪽 자식노드 순서로 방문
*/
