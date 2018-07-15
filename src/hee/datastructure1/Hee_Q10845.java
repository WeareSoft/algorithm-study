package hee.datastructure1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hee_Q10845 {
    static Scanner scanner = new Scanner(System.in);

    public static void run(){
        int N = scanner.nextInt();
        Queue queue = new LinkedList();

        while (N > 0){
            String command = scanner.next();

            switch (command){
                case "push":
                    queue.offer(scanner.nextInt());
                    break;

                case "pop":
                    System.out.println(queue.isEmpty() ? "-1" : queue.poll());
                    break;

                case "size":
                    System.out.println(queue.size());
                    break;

                case "empty":
                    System.out.println(queue.isEmpty() ? "1" : "0");
                    break;

                case "front":
                    System.out.println(queue.isEmpty() ? "-1" : ((LinkedList) queue).peekFirst());
                    break;

                case "back":
                    System.out.println(queue.isEmpty() ? "-1" : ((LinkedList) queue).peekLast());
                    break;

                default:
                    break;
            }
            N--;
        }
    }
}

