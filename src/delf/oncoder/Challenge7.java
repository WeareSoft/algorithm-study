package oncoder;

import java.util.Arrays;

/**
 * 정렬하기
 * https://www.oncoder.com/ground/rJwbIEaRm
 */
public class Challenge7 {
	public int[] solution(int[] arr) {
		return Arrays.stream(arr)
				.mapToObj(String::valueOf)
				.sorted(String::compareTo)
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}
