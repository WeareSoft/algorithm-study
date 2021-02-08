package hackerrank;

/* New Year Chaos
 * https://www.hackerrank.com/challenges/new-year-chaos
 * */
public class NewYearChaos {

    static void minimumBribes2(int[] q) {
        for (int i = 0; i < q.length; i++) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }

        int cnt = 0;
        for (int i = 0; i < q.length; i++) {
            if (i + 1 == q[i]) {
                continue;
            }
            int idx = i + 1;
            for (int j = idx; j < q.length; j++) {
                if (q[j] == idx) {
                    int tmp = q[j - 1];
                    q[j - 1] = q[j];
                    q[j] = tmp;
                    cnt++;
                    i--;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

    static void minimumBribes(int[] q) {
        int[] b = new int[q.length];
        int cnt = 0;
        for (int i = 0; i < q.length; i++) {
            for (int j = i + 1; j < q.length; j++) {
                if (q[i] > q[j]) {
                    cnt++;
                    b[q[i] - 1]++;
                    if (b[q[i] - 1] > 2) {
                        System.out.println("Too chaotic");
                        return;
                    }
                }
            }
        }
        System.out.println(cnt);
    }


    public static void main(String[] args) {
//        minimumBribes(new int[]{1, 2, 3, 4, 5, 6, 7, 8}); // tc
//        minimumBribes(new int[]{5, 1, 2, 3, 7, 8, 6, 4}); // tc
        minimumBribes2(new int[]{1, 2, 5, 3, 7, 8, 6, 4}); // 7
//        minimumBribes(new int[]{1, 2, 3, 4, 5}); // 3
//        minimumBribes(new int[]{2, 1, 5, 3, 4}); // 3
//        minimumBribes(new int[]{2, 1, 5, 3, 4}); // 3
//        minimumBribes(new int[]{2, 5, 1, 3, 4}); // tc

//        minimumBribes(new int[]{1, 2, 3, 4, 5});
    }
}

