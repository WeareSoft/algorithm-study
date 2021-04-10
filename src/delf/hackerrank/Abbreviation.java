package hackerrank;

/**
 * Abbreviation
 * https://www.hackerrank.com/challenges/abbreviation/problem
 */
public class Abbreviation {
    public static void main(String[] args) {
        System.out.println(abbreviation("daBcd", "ABC"));
        System.out.println(abbreviation("AfPZN", "APZNC"));
    }

    static String abbreviation(String a, String b) {
        boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                char aa = a.charAt(i - 1);
                if (j > 0 && dp[i - 1][j - 1]) {
                    char bb = b.charAt(j - 1);
                    if (aa == bb || Character.toUpperCase(aa) == bb) {
                        dp[i][j] = true;
                    }
                }
                if (Character.isLowerCase(aa) && dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[a.length()][b.length()] ? "YES" : "NO";
    }
}
