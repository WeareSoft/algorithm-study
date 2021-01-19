package dami.questions;

public class Task4 {
	public int solution(int N) {
		int digit = (int) Math.log10(N);
		if (digit == 0) {
			return 0;
		}
		return (int) Math.pow(10, digit);
	}
}
