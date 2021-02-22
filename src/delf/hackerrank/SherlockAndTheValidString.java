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
        System.out.println(isValid("aaaaabc"));
//        System.out.println(isValid(new String(Files.readAllBytes(Paths.get("src/delf/hackerrank/arg.txt")))));
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
            return true;
        }
        System.out.println(letterCounter);
        Map<Integer, Integer> frequencyCounter = new HashMap<>();
        for (int freq : letterCounter.values()) {
            frequencyCounter.merge(freq, 1, Integer::sum);
        }
        System.out.println(frequencyCounter);
        if (frequencyCounter.size() > 2) {
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
            int postValue = frequencyCounter.get(key);
            if (postValue == 1 || preValue == 1) {
                return true;
            }
            if (preKey - key == 1) {
                return true;
            }
        }
        return false;
    }
}
