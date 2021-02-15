package dami.codility.lesson5;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

// 문제 : https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
// 결과 : https://app.codility.com/demo/results/trainingN8CPTP-SQY/
public class CountDiv {
	// 시간 : O(1)
	public int solution(int A, int B, int K) {
		return (B / K) - (A % K == 0 ? A / K - 1 : A / K);
	}

	// 시간 : O(B-A) => O(1) 방법 있을듯
	public int timeout(int A, int B, int K) {
		int result = 0;
		for (int i = A; i <= B; i++) {
			if (i % K == 0) {
				result++;
			}
		}

		return result;
	}
}
