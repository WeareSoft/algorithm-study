package hee.codility.lesson;

public class PrefixSums_PassingCars {
    public int solution(int[] A) {
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1)
                total++;
        }

        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) { // E
                sum += (total - cnt);
            } else { // W
                cnt++;
            }

            if (sum > 1000000000)
                // System.out.println(-1);
                return -1;
        }
        // System.out.println(sum);
        return sum;
    }
}
