package hee.boj.datastructure1;

import java.util.Scanner;

public class Hee_Q10808 {
    static Scanner scanner = new Scanner(System.in);

    public static void run(){
        String S = scanner.next();
        int[] cnt = new int[26];

        for(int i=0; i<S.length(); i++){
            int c = S.charAt(i) - 'a';
            cnt[c]++;
        }

        for (int i=0; i<cnt.length; i++){
            System.out.print(cnt[i] + " ");
        }

//        int[] cnt = new int[200];
//
//        for (int i=0; i<S.length(); i++){
//            int c = S.charAt(i);
//            cnt[c]++;
//        }
//
//        for (int i='a'; i<='z'; i++){
//            System.out.print(cnt[i] + " ");
//        }
    }
}
