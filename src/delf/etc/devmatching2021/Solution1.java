package etc.devmatching2021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
        System.out.println(Arrays.toString(new Solution1().solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})));
        System.out.println(Arrays.toString(new Solution1().solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})));
    }

    private static final int[] WIN = new int[]{6, 6, 5, 4, 3, 2, 1};

    public int[] solution(int[] lottos, int[] winNums) {
        Set<Integer> set = new HashSet<>();
        for (int winNum : winNums) {
            set.add(winNum);
        }
        int empty = 0;
        for (Integer lotto : lottos) {
            if (lotto == 0) {
                empty++;
            }
            set.remove(lotto);
        }
        return new int[]{WIN[6 - set.size() + empty], WIN[6 - set.size()]};
    }
}
