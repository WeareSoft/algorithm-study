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
		List<Interval> list = new ArrayList<>();
		char[] arr = road.toCharArray();
		boolean isContinue = true;
		int start = 0;
		for (int i = 0; i < road.length(); i++) {
			if (isContinue) {
				if (i == road.length() - 1 || arr[i + 1] == '0') {
					list.add(new Interval(start, i));
					isContinue = false;
				}
				continue;
			}
			if (arr[i] == '1') {
				start = i;
				isContinue = true;
			}
		}

		int max = 0;
		int startInterval = 0;
		do {
			int sum = 0;
			int empty = 0;
			for (int i = startInterval; i < list.size() - 1; i++) {
				Interval tmp = list.get(i);
				sum += tmp.getLength();
				if ((empty += tmp.getDiff(list.get(i + 1))) > n) {
					break;
				}
			}
			max = Math.max(sum + n, max);
		} while (startInterval++ < list.size());

		return max;
	}

	class Interval {
		private int start;
		private int end;
		private int length;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
			length = end - start + 1;
		}

		public boolean isLonger(Interval interval) {
			return this.length > interval.length;
		}


		@Override
		public String toString() {
			return "Interval{" +
					"start=" + start +
					", end=" + end +
					", length=" + length +
					'}';
		}

		public int getLength() {
			return length;
		}

		public int getDiff(Interval interval) {
			return interval.start - this.end - 1;
		}
	}
}
