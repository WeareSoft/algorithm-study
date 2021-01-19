package dami.programmers.level2;

import java.util.stream.IntStream;

// https://hongjuzzang.github.io/solution/code_p68645/ 참고

public class 삼각_달팽이 {
	private static int[] answer;
	private static int value = 1;

	public int[] solution(int n) {
		answer = new int[snailSize(n)];
		int k = 0; // 루프 반복 횟수

		while (n >= 1) {
			fillArr(2 * k * (k + 1), 2 * k + 1, n, k);
			n -= 3;
			k++;
		}
		return answer;
	}

	private void fillArr(int startIndex, int sub, int n, int k) {
		if (n == 1) {
			answer[startIndex] = value;
			return;
		}

		// 아래로 이동
		// 아래로 내려갈수록 인덱스는 +1 계차수열
		// 첫번쨰 내부 삼각형의 시작 인덱스는 4이고 초기값이 2*반복횟수+1 부터 시작하는 +1 계차수열
		// 두번째 내부 삼각형의 시작 인덱스는 8이고 초기값이 2*반복횟수+1 부터 시작하는 +1 계차수열, . . .
		int index = startIndex;
		int count = n - 1; // 밑변 제외 횟수
		while (count > 0) {
			answer[index] = value++;
			index += sub++;
			count--;
		}

		// 우측으로 이동
		for (int i = 0; i < n; i++) {
			answer[index++] = value++;
		}

		// 위로 이동
		// 위로 올라갈수록 인덱스는 n의 -1 계차수열
		// 첫번째 내부 삼각형은 올라갈수록 n-1의 -1 계차
		// 두번쨰 내부 삼각형은 올라갈수록 n-2의 -1 계차, . . .
		index--;
		int nk = (n + 3 * k) - k; // 최초 n에 반복횟수 만큼 차감
		for (int i = 0; i < n - 2; i++) {
			index -= nk;
			answer[index] = value++;
			nk--;
		}
	}

	private int snailSize(int n) {
		return IntStream.range(1, n + 1).sum();
	}
}


/*
// 생각하다 포기
public class 삼각_달팽이 {

	public int[] solution(int n) {
		int[] answer = new int[snailSize(n)];

		int topIndex = 0;
		int vertexIndex = -4;
		int snailNo = 1;
		while (n > 0) {
			// 아래로 이동
			vertexIndex += 4;
			for (int i = 1; i <= n && snailNo <= answer.length; snailNo++, vertexIndex += topIndex + i++) {
				answer[vertexIndex] = snailNo;
			}

			// 우로 이동
			vertexIndex -= (topIndex + n) - 1;
			for (int i = 0; i < n - 1 && snailNo <= answer.length; snailNo++, vertexIndex++, i++) {
				answer[vertexIndex] = snailNo;
			}

			// 위로 이동
			vertexIndex -= n + 1;
			for (int i = 0; i < n - 2 && snailNo <= answer.length; snailNo++, vertexIndex -= n - ++i) {
				answer[vertexIndex] = snailNo;
			}

			n -= 3;
			topIndex += 2;
		}

		return answer;
	}

	private int snailSize(int n) {
		return IntStream.range(1, n + 1).sum();
	}
}
*/
