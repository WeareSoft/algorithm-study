package dami.programmers.level2;

public class 숫자의_표현 {
	public int solution(int n) {
		int answer = 1;

		for (int i = 1; i <= n / 2; i++) {
			int sum = 0;
			for (int j = i; sum < n; j++) {
				sum += j;

				if (sum == n) {
					answer++;
					break;
				}
			}
		}
		return answer;
	}

	// 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리가 있습니다.
	public int solution2(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i += 2)
			if (n % i == 0)
				answer++;
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new 숫자의_표현().solution2(15));
	}
}
