package hee.datastructure1;

import java.util.Scanner;

public class Hee_Q10820 {
    static Scanner scanner = new Scanner(System.in);

    public static void run(){

        while (scanner.hasNext()){
            int upperCnt = 0;
            int lowerCnt = 0;
            int blankCnt = 0;
            int numCnt = 0;

            String S = scanner.nextLine();

            for (int i=0; i<S.length(); i++){
                int num = S.charAt(i);

                if ('A' <= num && 'Z' >= num){
                    upperCnt++;
                } else if ('a' <= num && 'z' >= num) {
                    lowerCnt++;
                } else if ('0' <= num && '9' >= num) {
                    blankCnt++;
                } else if (num == ' '){
                    numCnt++;
                }
            }
            System.out.println(lowerCnt + " " + upperCnt + " " + blankCnt + " " + numCnt);
        }
    }
}
