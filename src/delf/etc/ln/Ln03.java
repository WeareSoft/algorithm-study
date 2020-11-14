package etc.ln;

import java.util.ArrayList;
import java.util.List;

/**
 * @author delf
 */
public class Ln03 {
	public static void main(String[] args) {
		System.out.println(new Ln03().solution("1110111100001111101111110000011111", 3));
		System.out.println(new Ln03().solution("001100", 5));

	}

	public int solution(String road, int n) {
		/* array로 표현된 road를 Interval의 List로 변환 */
		List<Interval> list = new ArrayList<>();
		char[] arr = road.toCharArray();
		boolean isContinue = true;
		int start = 0;
		for (int i = 0; i < road.length(); i++) {
			if (isContinue) { // 정상적인 도로였는데,
				if (i == road.length() - 1 || arr[i + 1] == '0') { // 끊기면
					list.add(new Interval(start, i)); // 거기까지가 새 구간
					isContinue = false;
				}
				continue;
			}
			if (arr[i] == '1') { // 처음 정상도로를 만나면,
				start = i; // 기록
				isContinue = true;
			}
		}

		int maxLength = 0;
		int startIntervalIdx = 0;
		do {
			int tmpTotal = 0;
			int brokenRoad = 0;
			for (int i = startIntervalIdx; i < list.size() - 1; i++) { // 시작 구간을 하나씩 옮겨가면서 완성된 구간의 길이 중 최댓값 기록
				Interval interval = list.get(i);
				tmpTotal += interval.getLength();
				if ((brokenRoad += interval.getMinimumDistanceTo(list.get(i + 1))) > n) { // 망가진 구간을 메워서 다음까지 연결 시킬 수 있는지 여부
					break;
				}
			}
			maxLength = Math.max(tmpTotal + n, maxLength); // 이번 루프에서 구간의 총 길이
		} while (startIntervalIdx++ < list.size());

		return maxLength;
	}

	// 정상도로 구간
	class Interval {
		private int start; // 정상적인 road가 시작되는 위차
		private int end; // 정상적인 road가 끝나는 위치
		private int length; // 구간의 길이

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
			length = end - start + 1;
		}

		public int getLength() {
			return length;
		}

		public int getMinimumDistanceTo(Interval interval) {
			return interval.start - this.end - 1;
		}
	}
}
