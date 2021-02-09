package programmers;

import java.util.Arrays;

/**
 * 자물쇠와 열쇠
 * https://programmers.co.kr/learn/courses/30/lessons/60059
 */
public class Solution60059 {
    public static void main(String[] args) {
//        System.out.println(/*new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}*/}
        int[][] tmp = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        System.out.println(Arrays.deepToString(rotate(tmp)));
    }

    public boolean solution(int[][] key, int[][] lock) {
        int size = lock.length - 1;

        for (int d = 0; d < 4; ++d) {
            int[][] rotatedKey = rotate(d, key);
            int[][] paddedKey = padding(rotatedKey, size);

            for (int rr = 0; rr < paddedKey.length - size; ++rr) {
                for (int cc = 0; cc < paddedKey[0].length - size; ++cc) {
                    boolean flag = true;

                    for (int r = 0; r < lock.length; ++r) {
                        for (int c = 0; c < lock[0].length; ++c) {
                            if (lock[r][c] == paddedKey[rr + r][cc + c]) {
                                flag = false;
                                break;
                            }
                        }
                    }

                    if (flag) return true;
                }
            }
        }

        return false;
    }

    private int[][] padding(int[][] arr, int size) {
        int[][] result = new int[arr.length + size * 2][arr[0].length + size * 2];

        for (int r = 0; r < arr.length; ++r) {
            System.arraycopy(arr[r], 0, result[r + size], size, arr[0].length);
        }

        return result;
    }

    private int[][] rotate(int cnt, int[][] arr) {
        if (cnt == 0) return arr;

        int[][] result = null;
        int[][] origin = copy(arr);

        for (int i = 0; i < cnt; ++i) {
            result = new int[arr.length][arr[0].length];

            for (int r = 0; r < origin.length; ++r) {
                for (int c = 0; c < origin[0].length; ++c) {
                    result[c][origin.length - 1 - r] = origin[r][c];
                }

            }
            origin = result;
        }

        return result;
    }

    private int[][] copy(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];

        for (int r = 0; r < arr.length; ++r) {
            for (int c = 0; c < arr[r].length; ++c) {
                result[r][c] = arr[r][c];
            }
        }

        return result;
    }

    public boolean solution2(int[][] key, int[][] lock) {
        for (int i = 0; i < 4; i++) {
            int[][] rotatedKey = rotate(key);
            if (isCorrect(rotatedKey, lock)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCorrect(int[][] key, int[][] lock) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (i < 0 || j < 0) {
                    continue;
                }
                System.out.println();
            }
        }
        return false;
    }

    private static int[][] rotate(int[][] key) {
        int[][] tmp = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                tmp[i][j] = key[j][key.length - (1 + i)];
            }
        }
        return tmp;
    }
}
