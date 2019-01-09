package hee.boj.datastructure1;

import java.util.Scanner;

public class Hee_Q10809 {
    static Scanner scanner = new Scanner(System.in);

    public static void run(){
        String S = scanner.next();

        for(int i='a'; i<='z'; i++) {
            System.out.print(S.indexOf(i)+" "); // 첫번째 글자의 위치
        }

//        int[] index = new int[26];
//
//        for (int i=0; i<S.length(); i++){
//            int c = S.charAt(i) - 'a';
//
//            if(index[c] == 0)
//                index[c] = i+1;
//        }
//
//        for (int i=0; i<index.length; i++){
//            System.out.print(index[i] == 0 ? "-1 " : index[i]-1 + " ");
//        }

    }
}
