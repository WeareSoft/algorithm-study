package dami.codility.lesson3.review;

// ⭐️
// 문제 : https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
// 결과1 (타임아웃) : https://app.codility.com/demo/results/trainingN3KWEQ-8DS/
// 결과2 : https://app.codility.com/demo/results/trainingEX47UA-2RY/

// position이 N+1일 때 매번 maxCounter 찍어주면 타임아웃 발생
public class MaxCounters {
	public int[] solution(int N, int[] A) {
		int[] result = new int[N];
		int max = 0;
		int finalMax = 0;
		for (int position : A) {
			if (position == N + 1) {
				finalMax = max;
			} else {
				if (result[position - 1] < finalMax) {
					result[position - 1] = finalMax;
				}
				max = Math.max(max, ++result[position - 1]);
			}
		}

		maxUp(result, finalMax);

		return result;
	}

	private void maxUp(int[] result, int max) {
		for (int i = 0; i < result.length; i++) {
			if (result[i] < max) {
				result[i] = max;
			}
		}
	}

}
