package oncoder;

/**
 * @author delf
 */
public class Challenge14 {
	public static void main(String[] args) {
		System.out.println(new Challenge14().solution(7, 3, 1));
		System.out.println(new Challenge14().solution(5, 3, 2));
		System.out.println(new Challenge14().solution(5, 5, 3));
	}

	public String solution(int n1, int n2, int K) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n1; i++) {
			sb.append("M");
		}
		for (int i = 0; i < n2; i++) {
			sb.insert(((K - 1) + (K * i)) % sb.length(), "F");
		}
		return sb.toString();
	}
}
