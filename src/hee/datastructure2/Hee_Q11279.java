package hee.datastructure2;

import java.util.Scanner;

// 최대힙 구현
public class Hee_Q11279 {
    static Scanner scanner = new Scanner(System.in);
    static int[] maxHeap;
    static int heapSize;

    static void insert_max_heap(int x){
        maxHeap[++heapSize] = x; // 힙 크기를 하나 증가하고 마지막 노드에 x를 넣는다.

        for (int i=heapSize; i>1; i/=2) {
            // 마지막 노드가 자신의 부모 노드보다 크면 swap
            if (maxHeap[i/2] < maxHeap[i]) {
                swap(i/2, i);
            } else {
                break;
            }
        }
    }

    static int delete_max_heap(){
        if (heapSize == 0) // 배열이 빈 경우
            return 0;

        int min = maxHeap[1]; // 루트 노드의 값을 저장한다.
        maxHeap[1] = maxHeap[heapSize]; // 마지막 노드의 값을 루트 노드에 둔다.
        maxHeap[heapSize--] = 0; // 힙 크기를 하나 줄이고 마지막 노드를 0으로 초기화한다.

        for (int i=1; i*2<=heapSize;) {
            // 마지막 노드가 왼쪽 노드와 오른쪽 노드보다 크면 반복문을 나간다.
            if (maxHeap[i] > maxHeap[i*2] && maxHeap[i] > maxHeap[i*2+1]) {
                break;
            }
            // 왼쪽 노드가 더 큰 경우, 왼쪽 노드와 마지막 노드를 swap
            else if (maxHeap[i*2] > maxHeap[i*2+1]) {
                swap(i, i*2);
                i = i*2;
            }
            // 오른쪽 노드가 더 큰 경우, 오른쪽 노드와 마지막 노드를 swap
            else {
                swap(i, i*2+1);
                i = i*2+1;
            }
        }
        return min;
    }

    static void swap(int index1, int index2) {
        int temp = maxHeap[index1];
        maxHeap[index1] = maxHeap[index2];
        maxHeap[index2] = temp;
    }

    public static void run() {
        int N = scanner.nextInt();
        maxHeap = new int[N + 1];

        while (N-- > 0) {
            int x = scanner.nextInt();

            if(x > 0) {
                insert_max_heap(x); // x가 자연수면 배열에 x추가
            } else if(x == 0) {
                System.out.println((delete_max_heap()));
            }
        }
    }

}
