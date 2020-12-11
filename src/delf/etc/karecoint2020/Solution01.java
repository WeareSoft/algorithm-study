package etc.karecoint2020;

public class Solution01 {
	public static void main(String[] args) {
		System.out.println(new Solution01().solution(2, 2));

	}

	public int solution(int m, int w) {
		return simplePermutation(m + w, 3) - ((simplePermutation(m, 3) + simplePermutation(w, 3)));
	}

	private int simplePermutation(int n, int r) {
		long m = 1;
		for (int i = n; i > n - r; i--) {
			m *= i;
		}
		System.out.println("m = " + m);
		long s = 1;
		for (int i = r; i > 0; i--) {
			s *= i;
		}
		System.out.println("s = " + s);
		return (int) (m / s);
	}
}