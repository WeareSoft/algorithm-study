package dami.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/64065

// 1. 중괄호 제거
// 2. 쉼표로 split
// {{4,2,3},{3},{2,3,4,1},{2,3}}
// 4,2,3,3,2,3,4,1,2,3
// 3. HashMap에 put
//   key : 각 숫자, value : 숫자 빈도수
// 4. 빈도수 오름차순 정렬해서 return

public class 튜플 {
	public int[] solution(String s) {
		s = s.replaceAll("\\{", "")
				.replaceAll("}", "");

		String[] numbers = s.split(",");
		Map<String, Integer> numberCountMap = new HashMap<>();
		for(String number : numbers) {
			numberCountMap.put(number, numberCountMap.getOrDefault(number, 0) + 1);
		}

		return numberCountMap.keySet()
				.stream()
				.sorted((key1, key2) -> numberCountMap.get(key2).compareTo(numberCountMap.get(key1)))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
}
