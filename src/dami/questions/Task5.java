package dami.questions;

// 참고 : https://github.com/geektimus/java-challenges/blob/master/src/main/java/com/codingmaniacs/codility/NumericChallenges.java
public class Task5 {
	public int solution(int N, int K) {
		if (K == 0) {
			return N - 1;
		}

		int minPlays = 0;

		while (N > 1 && K > 0) {
			if (N % 2 == 0) {
				K--;
				N /= 2;
			} else {
				N--;
			}
			minPlays++;
		}

		if (N > 1) {
			minPlays += N - 1;
		}
		return minPlays;
	}
}
