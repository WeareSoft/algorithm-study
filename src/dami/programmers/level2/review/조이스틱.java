package dami.programmers.level2.review;

import java.util.Arrays;
import java.util.stream.IntStream;

// 웩
// 1. 문자열 길이만큼 반복 돌리면서 상하 최소 이동값 전체 구하기
// 2. 좌우 최소 이동값 구하기
public class 조이스틱 {
	public int solution(String name) {
		char[] checkedName = name.toCharArray();
		return moveUpDown(checkedName) + moveLeftRight(checkedName);
	}

	private int moveUpDown(char[] name) {
		int count = 0;
		for (char alphabet : name) {
			count += Math.min(alphabet - 'A', 1 + 'Z' - alphabet);
		}
		return count;
	}

	private int moveLeftRight(char[] name) {
		char[] leftName = Arrays.copyOf(name, name.length);
		char[] rightName = Arrays.copyOf(name, name.length);
		leftName[0] = 'A';
		rightName[0] = 'A';

		int moveCount = 0;
		int leftIndex = 1, leftCount = 1;
		int rightIndex = name.length - 1, rightCount = 1;
		while (!isAllA(rightName)) {
			while (leftName[leftIndex] == 'A') {
				leftCount++;
				leftIndex = leftIndex % name.length;
			}
			leftName[leftIndex] = 'A';
			while (rightName[rightIndex] == 'A') {
				rightCount++;
				rightIndex = (rightIndex == 0 ? name.length - 1 : rightIndex) % name.length;
			}
			rightName[rightIndex] = 'A';

			moveCount += Math.min(leftCount, rightCount);

			leftIndex++;
			rightIndex--;
		}
		return moveCount;
	}

	private boolean isAllA(char[] name) {
		return IntStream.range(0, name.length)
				.mapToObj(i -> name[i])
				.allMatch(n -> n == 'A');
	}

}
