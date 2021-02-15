package dami.codility.lesson3;

// 문제 : https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
// 결과 : https://app.codility.com/demo/results/trainingJPBA75-MDR/
public class TapeEquilibrium {
	public int solution(int[] A) {
		int leftSum = A[0];
		int rightSum = 0;
		for (int i = 1; i < A.length; i++) {
			rightSum += A[i];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i < A.length; i++) {
			min = Math.min(min, Math.abs(leftSum - rightSum));

			leftSum += A[i];
			rightSum -= A[i];
		}

		return min;
	}
}
