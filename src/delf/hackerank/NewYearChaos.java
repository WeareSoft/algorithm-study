package hackerank;

/* New Year Chaos
* https://www.hackerrank.com/challenges/new-year-chaos
* */
public class NewYearChaos {
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
        minimumBribes(new int[]{5, 1, 2, 3, 7, 8, 6, 4}); // tc
        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4}); // 7
        minimumBribes(new int[]{2, 1, 5, 3, 4}); // 3
        minimumBribes(new int[]{2, 5, 1, 3, 4}); // tc

//        minimumBribes(new int[]{1, 2, 3, 4, 5});
    }
}

