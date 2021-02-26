package hackerrank;

/**
 * Common Child
 * https://www.hackerrank.com/challenges/common-child/problem
 */
public class CommonChild {
    public static void main(String[] args) {
//        System.out.println(commonChild("SHINCHAN", "NOHARAAA"));
        System.out.println(commonChild("FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC", "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS"));
    }

    // 이름있는 알고리즘이었다. 이름하여 'Longest common subsequence problem'
    // https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
    static int commonChild(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[][] dp = new int[c1.length + 1][c2.length + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[c1.length][c2.length];
    }

    /*
     * 두 문자열을 차례로 탐색하다가 같은 문자열을 만나면, 그 기준으로 다시 탐색하는 풀이
     * 시간초과 + 순서문제
     * */
    static int commonChild2(String s1, String s2) {
        int answer = 0;

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        for (int i = 0; i < s1Arr.length; i++) {
            for (int j = 0; j < s2Arr.length; j++) {
                int cnt = 0;
                if (s1Arr[i] != s2Arr[j]) {
                    continue;
                }
                cnt++;
                int sj = j + 1;
                for (int k = i + 1; k < s1Arr.length; k++) {
                    for (int l = sj + 1; l < s2Arr.length; l++) {
                        if (s1Arr[k] == s2Arr[l]) {
                            sj = l;
                            cnt++;
                            break;
                        }
                    }
                }
                answer = Math.max(answer, cnt);
            }
        }
        return answer;
    }

    private static boolean test(char[] s1, char[] s2, int si, int sj) {
        return false;
    }
}
