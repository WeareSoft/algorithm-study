package programmers;

import java.util.*;

/**
 * [1차] 프렌즈4블록
 * https://programmers.co.kr/learn/courses/30/lessons/17679
 */
public class Solution17679 {
    public static void main(String[] args) {
//        System.out.println(new Solution17679().solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
//        System.out.println(new Solution17679().solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
//        System.out.println(new Solution17679().solution(6, 6, new String[]{"AABBEE", "AAAEEE", "VAAEEV", "AABBEE", "AACCEE", "VVCCEE"}));
//        System.out.println(new Solution17679().solution(2, 2, new String[]{"AA", "AB"}));
//        System.out.println(new Solution17679().solution(3, 2, new String[]{"AA", "AA", "AB"}));
//        System.out.println(new Solution17679().solution(4, 2, new String[]{"CC", "AA", "AA", "CC"}));
        System.out.println(new Solution17679().solution(6, 2, new String[]{"DD", "CC", "AA", "AA", "CC", "DD"}));
//        System.out.println(new Solution17679().solution(8, 2, new String[]{"FF", "AA", "CC", "AA", "AA", "CC", "DD", "FF"}));
//        System.out.println(new Solution17679().solution(6, 2, new String[]{"AA", "AA", "CC", "AA", "AA", "DD"}));


    }

    private char[][] chBoard;
    int[][] DIR = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public int solution(int m, int n, String[] board) {
        chBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                chBoard[i][j] = board[i].charAt(j);
            }
        }

        int answer = 0;
        Set<Block> marker = new LinkedHashSet<>(); // 삭제할 블록
        do {
            marker.clear();
            // 스캔
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (isWindowBingo(i, j)) {
                        for (int[] d : DIR) {
                            marker.add(new Block(i + d[0], j + d[1]));
                        }
                    }
                }
            }

            // 처리
            for (Block block : marker) {
                for (int mm = block.m; mm >= 0; mm--) {
                    if (mm - 1 < 0) {
                        chBoard[mm][block.n] = '0';
                        break;
                    }
                    if (chBoard[mm - 1][block.n] != '0') {
                        chBoard[mm][block.n] = chBoard[mm - 1][block.n];
                    } else {
                        chBoard[mm][block.n] = '0';
                        break;
                    }
                }
            }
            answer += marker.size();
        } while (marker.size() > 0);

        return answer;
    }

    private boolean isWindowBingo(int m, int n) {
        if (chBoard[m][n] == '0' || chBoard[m][n] != chBoard[m][n + 1]) {
            return false;
        }
        if (chBoard[m][n + 1] == '0' || chBoard[m][n + 1] != chBoard[m + 1][n]) {
            return false;
        }
        return chBoard[m + 1][n] == '0' || chBoard[m + 1][n] == chBoard[m + 1][n + 1];
    }

    static class Block {
        int m;
        int n;

        public Block(int m, int n) {
            this.m = m;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Block block = (Block) o;

            if (m != block.m) return false;
            return n == block.n;
        }

        @Override
        public int hashCode() {
            int result = m;
            result = 31 * result + n;
            return result;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", m, n);
        }
    }
}