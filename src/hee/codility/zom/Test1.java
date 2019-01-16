package hee.codility.zom;

public class Test1 {
    public int solution(int[] A) {
        if (A.length == 1) {
//            System.out.println(1);
//            return;
            return 1;
        }

        int cnt = 0;
        int i = 0;
        while (true) {
            if (A[i] == -1) {
                ++cnt;
                break;
            }
            i = A[i];
            ++cnt;
        }
//        System.out.println(cnt);
        return cnt;
    }
}
