package hee.codility.lesson;

public class Iterations_BinaryGap {
    public int solution(int N) {
        String n = Integer.toBinaryString(N);

        int maxGap = 0;
        int startIdx = 0, endIdx = 1;

        while (n.length() > endIdx) {
            if(n.charAt(endIdx) == '1') {
                int gap = endIdx - startIdx - 1;
                startIdx = endIdx;

                if (maxGap <= gap) {
                    maxGap = gap;
                }
            }
            endIdx++;
        }
        return maxGap;
    }
}
