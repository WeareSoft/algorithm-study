package dami.codility.lesson1;

// 문제 : https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
// 결과 : https://app.codility.com/demo/results/trainingVA6BQ5-M7Z/
public class BinaryGap {
	public int solution(int N) {
		String binaryString = Integer.toBinaryString(N);
		int max = 0, count = 0;

		for (int i = 0; i < binaryString.length(); i++) {
			if (binaryString.charAt(i) == '1') {
				max = Math.max(max, count);
				count = 0;
			} else {
				count++;
			}
		}

		return max;
	}
}
