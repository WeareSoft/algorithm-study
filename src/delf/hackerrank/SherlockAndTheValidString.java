package hackerrank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Sherlock and the Valid String
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 */
public class SherlockAndTheValidString {

    public static void main(String[] args) throws IOException {
//        System.out.println(isValid("aaaaabc"));
//        System.out.println(isValid("aabbccddeefghi"));
//        System.out.println(isValid("abcdefghhgfedecba"));
    }

    static String isValid(String s) {
        return isValidB(s) ? "YES" : "NO";
    }

    private static boolean isValidB(String s) {
        Map<Character, Integer> letterCounter = new HashMap<>();
        for (char ch : s.toCharArray()) {
            letterCounter.merge(ch, 1, Integer::sum);
        }
        if (letterCounter.size() < 2) {
            // '문자'가 모두 같은 케이스 (remove 없이도 valid 함)
            return true;
        }
        Map<Integer, Integer> frequencyCounter = new HashMap<>();
        for (int freq : letterCounter.values()) {
            frequencyCounter.merge(freq, 1, Integer::sum);
        }

        if (frequencyCounter.size() == 1) {
            // '빈도수'가 모두 같은 케이스 (remove 없이도 valid 함)
            return true;
        }

        if (frequencyCounter.size() > 2) {
            // '빈도수' 3 이상인 케이스. 즉, remove 한번으로 valid하게 만들기가 불가능
            return false;
        }

        int preKey = 0;
        int preValue = 0;
        for (int key : frequencyCounter.keySet()) {
            if (preKey == 0 && preValue == 0) {
                preKey = key;
                preValue = frequencyCounter.get(key);
                continue;
            }
            if (preKey == 1) { // 가장 적은 빈도수가 한번이고,
                // 그런 경우가 하나인 경우 ('문자' 자체가 하나이고, 그걸 remove)
                return preValue == 1;
            }
            // '빈도수'를 하나를 remove 함으로써 다른 빈도수와 같게하는 케이스
            return key - preKey == 1; //
        }
        throw new IllegalArgumentException();
    }
}

/*
 * # case 1: {}, {a=3}
 * # case 2: {a=2, b=2, c=2}
 * # case 3: {a=1, b=2, c=3}
 * # case 4: {a=1, b=3, c=3}(true), {a=1, b=1, c=3}(false)
 * # case 5: {a=5, b=5, c=6}(true)
 * */
