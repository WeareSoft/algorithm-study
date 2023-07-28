package dami.programmers.level2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class 피보나치_수 {

	private static final int[] FIVO = new int[100001];

	public int solution(int n) {
		Arrays.fill(FIVO, -1);
		for (int i = 0; i <= n; i++) {
			fivo(i);
		}
		return FIVO[n];
	}

	private int fivo(int n) {
		if (FIVO[n] != -1) return FIVO[n];
		if (n == 0) return 0;
		if (n == 1) return 1;

		return FIVO[n] = (fivo(n - 1) + fivo(n - 2)) % 1234567;
	}

	public static void main(String[] args) {
		System.out.println(new 피보나치_수().solution(100000));
	}
}
