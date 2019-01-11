package hee.codility.lesson;

public class PrefixSums_CountDiv {
    // [TIP] input [11, 14, 2] 항상 짝수/홀수 구분해서 모두 테스트해보기!!
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        if (A == B) {
            if (A % K == 0)
                return 1;
            else
                return 0;
        }

        if (A % K > 0) {
            return (B / K) - (A / K);
        } else {
            return (B / K) - (A / K) + 1;
        }
    }
}
