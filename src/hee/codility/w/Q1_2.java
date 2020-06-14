package hee.codility.w;

import java.util.HashMap;

public class Q1_2 {
    public final static int RADIX = 10;

    public static void main(String[] args) {
        String A = "A586QK";
        String B = "JJ653K";
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 2; i < 10; i++)
            hashMap.put(Character.forDigit(i, RADIX), i);
        hashMap.put('T', 10);
        hashMap.put('J', 11);
        hashMap.put('Q', 12);
        hashMap.put('K', 13);
        hashMap.put('A', 14);

        int cnt = 0;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (hashMap.get(a[i]) > hashMap.get(b[i])) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
