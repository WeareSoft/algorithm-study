package oncoder;

/**
 * 셀프넘버 판별
 * https://www.oncoder.com/ground/B12g8N6RX
 */
public class Challenge6 {
	public int solution(int a) {
		int cnt = 0;
		for (int i = 1; i <= a; i++) {
			if (F(i) == a) {
				cnt++;
			}
		}
		return cnt;
	}

	private static int F(final int n) {
		int sum = 0;
		int cursor = n;
		do {
			sum += cursor % 10;
		} while ((cursor /= 10) > 0);
		return n + sum;
	}
}
