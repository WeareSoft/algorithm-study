package hackerrank;

import java.util.*;

/**
 * Special String Again
 * https://www.hackerrank.com/challenges/special-palindrome-again/problem
 */
/*
 * 주어진 문자열을 '문자 덩어리의 배열'로 표현
 * (여기서 문자 덩어리란, 연속된 같은 문자의 모음을 뜻함)
 * 1. 각 문자 덩어리 하나로 만들 수 있는 special string의 수를 계산
 *      - 연속된 부분집합의 개수. S(n)라는 집합이 있으면, 1+2+...+n. 즉 n*(n+1)/2
 * 2. 여러개의 문자 덩어리로 만들 수 있는 special string의 수를 계산
 *      - 문자 덩어리를 세개를 기준으로, 가운데 문자 덩어리의 개수가 1이면서 양쪽의 문자가 같은 경우
 *      - 양쪽 문자 덩어리의 개수중 적은 쪽이 special string
 *      - ex) bbabbb (b=2, a=1, b=3) -> bab, bbabb 두가지
 * */
public class SpecialStringAgain {
    static long substrCount(String s) {
        List<CharacterChunk> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        char tmp = arr[0];
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (tmp != arr[i]) {
                list.add(new CharacterChunk(tmp, cnt));
                cnt = 0;
                tmp = arr[i];
            }
            cnt++;
        }
        list.add(new CharacterChunk(tmp, cnt));

        int answer = 0;
        for (CharacterChunk characterChunk : list) {
            int n = characterChunk.q;
            answer += (n * (n + 1) / 2);
        }

        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i).q != 1) {
                continue;
            }
            if (list.get(i - 1).v != list.get(i + 1).v) {
                continue;
            }
            answer += (Math.min(list.get(i - 1).q, list.get(i + 1).q));
        }
        return answer;
    }

    static class CharacterChunk {
        char v; // value
        int q; // quantity

        CharacterChunk(char value, int quantity) {
            this.v = value;
            this.q = quantity;
        }
    }


    static long substrCount2(int n, String s) {
        int len = 1;
        long cnt = 0;
        char[] arr = s.toCharArray();
        do {
            for (int i = 0; i <= s.length() - len; i++) {
                cnt += isSpecialString(arr, i, i + len) ? 1 : 0;
            }
        } while (len++ < s.length());

        return cnt;
    }

    private static boolean isSpecialString(char[] s, int start, int end) {
        int len = end - start;
        if (len < 2) {
            return true;
        }

        char first = s[start];
        if (len % 2 == 0) {
            for (int i = start + 1; i < end; i++) {
                if (first != s[i]) {
                    return false;
                }
            }
        } else {
            for (int i = start + 1; i < end; i++) {
                if (first != s[i]) {
                    if (i - start != (len / 2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
