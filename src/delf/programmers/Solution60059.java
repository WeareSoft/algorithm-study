package programmers;

import java.security.acl.LastOwnerException;

/**
 * 자물쇠와 열쇠
 * https://programmers.co.kr/learn/courses/30/lessons/60059
 */
public class Solution60059 {
    public static void main(String[] args) {
        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = new int[][]{{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 0, 1, 1}};

        System.out.println(new Solution60059().solution3(key, lock));
    }


    private int lockHole;

    public boolean solution3(int[][] key, int[][] lock) {
        boolean[][] bKey = new boolean[key.length][key.length];
        boolean[][] bLock = new boolean[lock.length][lock.length];

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 1) {
                    bLock[i][j] = true;
                } else {
                    lockHole++;
                }
            }
        }

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                bKey[i][j] = key[i][j] == 1;
            }
        }

        int n = lock.length + key.length - 1;

        boolean[][] rotatedKey = bKey;
        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (fit(i - (key.length - 1), j - (key.length - 1), rotatedKey, bLock)) {
                        return true;
                    }
                }
            }
            rotatedKey = rotate(rotatedKey);
        }
        return false;
    }

    private boolean[][] rotate(boolean[][] key) {
        boolean[][] tmp = new boolean[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                tmp[i][j] = key[j][key.length - (1 + i)];
            }
        }
        return tmp;
    }

    private boolean fit(int ii, int jj, boolean[][] rotatedKey, boolean[][] lock) {
        int n = rotatedKey.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ii + i < 0 || ii + i >= lock.length || jj + j < 0 || jj + j >= lock.length) {
                    continue;
                }
                boolean k = rotatedKey[i][j];
                boolean l = lock[ii + i][jj + j];
                if (k && l) { // k = true, l = true
                    return false;
                }
                if (k) { // k = true, l = false
                    cnt++;
                }
                // k = false, l = true
                // k = false, l = false
            }
        }
        return cnt == lockHole;
    }
}
