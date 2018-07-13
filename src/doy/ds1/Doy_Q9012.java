package doy.ds1;

import java.util.Scanner;

public class Doy_Q9012 {
    static Scanner s = new Scanner(System.in);

    private static boolean isValidParenthesisString(String input) {
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(')
                cnt++;
            else {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }

        if (cnt == 0) {
            return true;
        }
        return false;
    }

    private static String getOutput(boolean result) {
        if (result)
            return "YES";
        return "NO";
    }

    public static void run() {
        int n = s.nextInt();
        while(n > 0) {
            String input = s.next();
            System.out.println(getOutput(isValidParenthesisString(input)));
            n--;
        }
    }
}

/*
    풀이는 동일하네요.
    함수를 여러개로 나누어 조금 더 구조화한 게 보이네요^^
    이런 습관을 자연스럽게 만들면 좋을 거 같아요.
*/
