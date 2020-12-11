package dami.questions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 인덱스, 개수 계산 헷갈렸던 문제

// 1. 0의 index값을 가지는 List 생성
// 2. n이 0의 위치 리스트 크기보다 같거나 크면 road 길이 반환
// 3. 0의 위치 리스트 맨 앞부터 반복
//  - n개씩 보수한 결과 도로 길이 최대값 계산
public class Line3 {
	public int solution(String road, int n) {
		List<Integer> zeroIndexes = IntStream.range(0, road.length())
				.boxed()
				.filter(num -> road.charAt(num) == '0')
				.collect(Collectors.toList());

		int zeroCount = zeroIndexes.size();
		if (zeroCount <= n) {
			return road.length();
		}

		// zeroIndexes 앞에부터 n개씩 반복할 때
		// 첫 턴 : start = 0, end = zi[i + n]
		// 둘째 턴 ~ 마지막 전 턴 : start = zi[i - 1] + 1, end = zi[i + n]
		// 마지막 턴 : start = zi[i - 1] + 1, end = road.length() - 1
		// 가 되기 때문에 zeroIndexes list에 추가
		//    1 1 1 0 1 1 1 1 0 0 1 1 1 1 1 0 1 1 1 1 1 0 0 0 1 1 1 1 1
		// -1 0 1 2 3 4 5 6 7 8 9 . . .   14. . . . . . .             29
		zeroIndexes.add(0, -1);
		zeroIndexes.add(road.length() - 1);

		int max = 0;
		// 0의 인덱스 리스트 총 개수만큼(zeroCount)에서 마지막 n개가 될 수 있는 i까지만 반복
		// ex. n=3일 때, zi = {3, 8, 9, 15, 22, 23, 24}에서 22(=zi[4])까지만 반복
		for (int i = 1; i <= zeroCount - n; i++) {
			int start = zeroIndexes.get(i - 1) + 1;
			int end = zeroIndexes.get(i + n);
			int length = end - start;
			max = Math.max(length, max);
		}
		return max;
	}
}
