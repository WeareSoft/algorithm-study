package hackerrank;

import java.util.Arrays;
import java.util.LinkedList;

public class ATaleofTwoStacks {
    public static void main(String[] args) {

        Arrays.sort(new long[0]);
    }
    class MyQueue<T> {

        private LinkedList<T> list = new LinkedList<>();

        void enqueue(T e) {
            list.add(e);
        }

        T dequeue() {
            return list.removeFirst();
        }

        T peek() {
            return list.getLast();
        }
    }


}
