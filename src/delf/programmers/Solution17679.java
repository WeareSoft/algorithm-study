package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [1차] 프렌즈4블록
 * https://programmers.co.kr/learn/courses/30/lessons/17679
 */
public class Solution17679 {
    public static void main(String[] args) {
        System.out.println(new Solution17679().solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(new Solution17679().solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char arr[][];
    static int mm;
    static int nn;
    static Queue<Pos> qu = new LinkedList<>();

    public static void square(int x, int y, char c) {
        int dx[] = {0, 1, 1};
        int dy[] = {1, 0, 1};

        Queue<Pos> temp = new LinkedList<Pos>();

        for (int i = 0; i < 3; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && nx < mm && ny >= 0 && ny < nn && arr[nx][ny] == c) {
                temp.add(new Pos(nx, ny));
            }
        }

        if (temp.size() == 3) {
            qu.add(new Pos(x, y));
            for (int i = 0; i < 3; i++) {
                qu.add(temp.poll());
            }
        }

    }

    public static void down() {
        for (int k = 0; k < mm; k++) {
            for (int i = mm - 1; i > 0; i--) {
                for (int j = 0; j < nn; j++) {
                    if (arr[i][j] == '0' && arr[i - 1][j] != '0') {
                        arr[i][j] = arr[i - 1][j];
                        arr[i - 1][j] = '0';
                    }
                }
            }
        }
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        arr = new char[m][n];
        mm = m;
        nn = n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }

        int cnt = 0;
        while (cnt < 1000) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] != '0')
                        square(i, j, arr[i][j]);
                }
            }

            while (!qu.isEmpty()) {
                Pos p = qu.poll();

                if (arr[p.x][p.y] != '0') {
                    arr[p.x][p.y] = '0';
                    answer++;
                } else
                    continue;
            }

            //내려주고
            down();
            cnt++;
        }

        return answer;
    }
}