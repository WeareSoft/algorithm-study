package hee.leetcode;

public class NumJewelsInStones_771 {
    public int numJewelsInStones(String J, String S) {
        for (int i=0; i<J.length(); i++) {
            S = S.replace(J.charAt(i), '*');
        }
//        System.out.println(S);
        int result = 0;
        for (char check : S.toCharArray()) {
            if ('*' == check) {
                result ++;
            }
        }
//        System.out.println(result);
        return result;
    }
}
