package dami.programmers.level2;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

// https://programmers.co.kr/learn/courses/30/lessons/17686

// 정렬 기준에 따라 차이가 없다면 원래 입력에서 주어진 순서를 유지하는 안정 정렬
// 안정 정렬 O : 병합, 버블, 삽입
// 안정 정렬 X : 퀵
// C++과 Python에는 안정 정렬이 있고, Java와 JavaScript, Swift에는 안정 정렬이 없음
// 안정 정렬을 지원하지 않거나, 이 문제처럼 비교 조건이 까다로운 경우에는 decorate-sort-undecorate 패턴을 이용해서 쉽게 해결할 수도

// 1. key는 파일명, value는 각각 head와 number를 가지는 headMap, numberMap 생성
// 2. 각각 head와 number부 분리해서 저장
// 3. 조건에 맞게 정렬해서 결과 반환
public class 파일명_정렬 {
	private static final int MAX_NUMBER_SIZE = 5;
	private static final String NUMBER = Pattern.compile("[0-9]{1,5}").pattern();
	private static final String CHARACTER = Pattern.compile("[\\sa-z.-]").pattern();

	public String[] solution(String[] files) {
		Map<String, String> headMap = new LinkedHashMap<>();
		Map<String, Integer> numberMap = new LinkedHashMap<>();
		for (String file : files) {
			String[] split = file.split(NUMBER);
			headMap.put(file, split[0].toLowerCase());
			numberMap.put(file, splitNumber(file, split));
		}

		return headMap.keySet().stream()
				.sorted((key1, key2) -> {
					if (headMap.get(key1).equals(headMap.get(key2))) {
						return numberMap.get(key1) - numberMap.get(key2);
					}
					return headMap.get(key1).compareTo(headMap.get(key2));
				})
				.toArray(String[]::new);
	}

	private Integer splitNumber(String file, String[] split) {
		String numberString = file.substring(split[0].length(), Math.min(file.length(), MAX_NUMBER_SIZE + split[0].length()));
		if (split.length < 2) {
			return Integer.parseInt(numberString);
		}

		return Integer.parseInt(numberString.split(CHARACTER)[0]);
	}

}
