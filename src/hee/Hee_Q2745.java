package hee;

import java.util.ArrayList;
import java.util.Scanner;

public class Hee_Q2745 {
    static Scanner scanner = new Scanner(System.in);

    static int charToCode(Character num) {
        // 아스키 코드 값이 48 ~ 57사이면 0과 9사이의 문자

        // 숫자가 아닌 경우
        if (num < '0' || num > '9') {
            return num - 55;
        } else {
            return num - '0'; // char -> int
        }
    }

    public static void run() {
        StringBuilder stringBuilder = new StringBuilder(scanner.next());
        int proposition = scanner.nextInt();

        // Ex. 12130
        // 0, 3, 1, 2, 1 순서
        stringBuilder.reverse();

        int result = 0;
        for(int i=0; i<stringBuilder.length(); i++){
            Character num = stringBuilder.charAt(i);

            // 0*(proposition^0), 3*(proposition^1)
            result += charToCode(num) + Math.pow(proposition, i);
        }

        // 값 출력
        System.out.print(result);
    }
}

// reference: http://mytalkhome.tistory.com/422
// https://stackoverflow.com/questions/46343616/how-can-i-convert-a-char-to-int-in-java/46343671