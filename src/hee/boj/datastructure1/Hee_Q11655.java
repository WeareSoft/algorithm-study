package hee.boj.datastructure1;

import java.util.Scanner;

public class Hee_Q11655 {
    static Scanner scanner = new Scanner(System.in);

    public static void run(){
        String S = scanner.nextLine();

        for (int i=0; i<S.length(); i++){
            int num = S.charAt(i);
            int rot13 = num + 13;

            if(num >= 'A' && num <= 'Z'){
                System.out.print(num <= 'Z'-13 ? (char)rot13 : (char)((rot13 % 'Z') + 64));
            } else if(num >= 'a' && num <= 'z'){
                System.out.print(num <= 'z'-13 ? (char)rot13 : (char)((rot13 % 'z') + 96));
            } else {
                System.out.print((char)num);
            }

//            char num = S.charAt(i);
//            if(num >= 'A' && num <= 'Z'){
//                num = (char)((num - 'A' + 13) % 26 + 'A');
//
//            } else if(num >= 'a' && num <= 'z'){
//                num = (char)((num - 'a' + 13) % 26 + 'a');
//            }
//            System.out.print(num);

        }
    }
}
