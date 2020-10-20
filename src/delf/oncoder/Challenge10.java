package oncoder;

/**
 * 평형점 구하기
 * https://www.oncoder.com/ground/BkIQ8NT0Q
 */
public class Challenge10 {
	public static void main(String[] args) {
		System.out.println(new Challenge10().solution(-1, 1, 2, 1000));
	}

	public double solution(int x1, int m1, int x2, int m2) {
		if (m1 == m2) {
			return (double) (x1 + x2) / 2.0;
		}
		int biggerX = Math.max(x1, x2);
		int smallerX = Math.min(x1, x2);
		return smallerX + ((m1 - Math.sqrt(m1) * Math.sqrt(m2)) * (biggerX - smallerX)) / (m1 - m2);
	}

}
