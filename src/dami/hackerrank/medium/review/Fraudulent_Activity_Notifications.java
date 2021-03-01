package dami.hackerrank.medium.review;

import java.util.PriorityQueue;

// https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting&h_r=next-challenge&h_v=zen
// counting sort 사용하기
public class Fraudulent_Activity_Notifications {
	private static final int MAX_VALUE = 201;

	public int activityNotifications(int[] expenditure, int d) {
		int[] counting = new int [MAX_VALUE];
		for (int i = 0; i < d; i++) {
			counting[expenditure[i]]++;
		}

		int result = 0;
		for (int i = d; i < expenditure.length; i++) {
			double median = findMedian(counting, d);
			if (median * 2 <= expenditure[i]) {
				result++;
			}

			counting[expenditure[i]]++;
			counting[expenditure[i - d]]--;
		}

		return result;
	}

	private double findMedian(int[] counting, int d) {
		double median = 0;
		int count = 0;

		if (d % 2 == 0) {
			int left = 0;
			int right = 0;
			for (int i = 0; i < counting.length; i++) {
				count += counting[i];
				if (count >= d / 2) {
					left = i;
				} else if (count >= d / 2 + 1) {
					right = i;
					break;
				}
			}
			median = (left + right) / 2.0;

		} else {
			for (int i = 0; i < counting.length; i++) {
				count += counting[i];
				if (count > d / 2) {
					median = i;
					break;
				}
			}
		}
		return median;
	}



	// O(n)
	private int[] countingSort(int[] expenditure, int start, int d) {
		int[] sorted = new int[d];
		int[] counting = new int [MAX_VALUE];
		for (int i = start; i < start + d; i++) {
			counting[expenditure[i]]++;
		}
		for (int i = 1; i < counting.length; i++) {
			counting[i] += counting[i - 1];
		}
		for (int i = start; i < start + d; i++) {
			sorted[--counting[expenditure[i]]] = expenditure[i];
		}
		return sorted;
	}

	/* // timeout
	public int activityNotifications(int[] expenditure, int d) {
		PriorityQueue<Integer> trailingDays = new PriorityQueue<>();
		for (int i = 0; i < d; i++) {
			trailingDays.offer(expenditure[i]);
		}

		int result = 0;
		for (int i = d; i < expenditure.length; i++) {
			int median = findMedian(new PriorityQueue<>(trailingDays), trailingDays.size());
			if (median * 2 <= expenditure[i]) {
				result++;
			}

			trailingDays.poll();
			trailingDays.offer(expenditure[i]);
		}

		return result;
	}

	private int findMedian(PriorityQueue<Integer> trailingDays, int size) {
		int mid = size / 2;

		while (mid != 0) {
			trailingDays.poll();
			mid--;
		}


		if (size % 2 == 0) {
			return (trailingDays.poll() + trailingDays.poll()) / 2;
		} else {
			return trailingDays.poll();
		}
	}
	*/
}
