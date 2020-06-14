package hee.codility.naverfin;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    Set<String> charSet = new HashSet<>();

    public int solution(String S) {
        if (S == null || S.isEmpty()) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            String checkChar = Character.toString(S.charAt(i));
            if (charSet.contains(checkChar)) {
                result++;
                initSet();
            }
            charSet.add(checkChar);
        }
        if (charSet.size() != 0) {
            result++;
        }
        return result;
    }

    private void initSet() {
        charSet = new HashSet<>();
    }
}
