package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 셜록과 아나그램
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 */
public class SherlockAndAnagram {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("kkkk"));
    }

    static int sherlockAndAnagrams(String s) {
        Map<String, Integer> counter = new HashMap<>();
        int len = 1;
        do {
            for (int i = 0; i <= s.length() - len; i++) {
                char[] c = s.substring(i, i + len).toCharArray();
                Arrays.sort(c);
                counter.merge(new String(c), 1, Integer::sum);
            }
        } while (len++ < s.length());

        int cnt = 0;
        for (String str : counter.keySet()) {
            int n = counter.get(str);
            if (n > 1) {
                cnt += (n * (n - 1) / 2);
            }
        }
        return cnt;
    }

    static int sherlockAndAnagrams2(String s) {
        Map<Anagram, Integer> counter = new HashMap<>();
        int len = 1;
        do {
            for (int i = 0; i <= s.length() - len; i++) {
                counter.merge(new Anagram(s.substring(i, i + len)), 1, Integer::sum);
            }
        } while (len++ < s.length());

        int cnt = 0;
        for (Anagram anagram : counter.keySet()) {
            int n = counter.get(anagram);
            if (n > 1) {
                cnt += (n * (n - 1) / 2);
            }
        }
        return cnt;

    }

    static class Anagram {
        String string;

        Anagram(String string) {
            this.string = string;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Anagram a = (Anagram) obj;

            if (this.string.length() != a.string.length()) {
                return false;
            }
            char[] c1 = this.string.toCharArray();
            char[] c2 = a.string.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            return Arrays.equals(c1, c2);
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            return string;
        }
    }
}