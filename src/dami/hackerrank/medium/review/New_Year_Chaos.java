package dami.hackerrank.medium.review;

// https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

// 현재 위치 : 1  2  5  3  7  8  6  4
// 처음 위치 : 1  2  3  4  5  6  7  8
// 위치 차이 : 0  0  2 -1  2  2 -1 -4
// 1. 이동 수(위치 차이)가 2보다 큰 경우는 chaotic
// 2. 현재 값이 원래 있어야 할 위치 - 2부터 현재 값 위치까지 반복하면서 현재 값보다 큰 수 있으면 count++ (뒤로 밀어주는 것)
// ⭐️뒤 부터 반복
public class New_Year_Chaos {

	public void minimumBribes(int[] q) {
		int count = 0;
		for (int i = q.length - 1; i >= 0; i--) {
			if (q[i] - (i + 1) > 2) {
				System.out.println("Too chaotic");
				return;
			}

			for (int j = Math.max(0, q[i] - 2); j < i; j++) {
				if (q[j] > q[i]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
