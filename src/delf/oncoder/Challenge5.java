package oncoder;

/**
 * 13 구하기
 * https://www.oncoder.com/ground/B12g8N6RX
 */
public class Challenge5 {
	public int solution(int a) {
		int cnt = 0;
		for (int i = 1; i <= a; i++) {
			int tmp = i;
			do {
				if ((tmp - 13) % 100 == 0) {
					cnt++;
					break;
				}
			} while ((tmp /= 10) > 0);
		}
		return cnt;
	}
}
