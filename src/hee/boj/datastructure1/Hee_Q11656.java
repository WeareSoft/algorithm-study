package hee.boj.datastructure1;

import java.util.Arrays;
import java.util.Scanner;

public class Hee_Q11656 {
    static Scanner scanner = new Scanner(System.in);

    public static void run(){
        String S = scanner.next();
        String[] suffix = new String[S.length()];

        for (int i=0; i<S.length(); i++){
            suffix[i] = S.substring(i);
        }
        Arrays.sort(suffix);
        for (int i=0; i<S.length(); i++){
            System.out.println(suffix[i]);
        }
    }
}
