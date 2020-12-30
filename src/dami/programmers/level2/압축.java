package dami.programmers.level2;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/17684

// 풀이 방법이 문제 설명에 나와있어서 금방 풀 수 있을줄 알았는데 생각보다 오래 걸린 문제
// 조건처리를 깔끔하게 해주지 못한 느낌이고, 그냥 처음에 A-Z까지 해시맵에 초기화 해놓고 이후 단어들 추가하는 방법으로 구현하는게 나았을까 싶음ㅜㅜ

// 1. offset에 압축할 단어 시작 위치 지정
// 2. 현재 문자의 색인값 조회
// offset이 마지막 문자를 가리키고 있으면 반복 중단
// 4. 색인값 확인했을 때 한자리 문자면 현재문자+다음문자 사전에 추가
//                   두자리 이상 문자면 마지막 문자열인지 확인하고, 아닐 경우 현재문자열+다음문자 사전에 추가
public class 압축 {
	public int[] solution(String msg) {
		List<Integer> result = new ArrayList<>();
		List<String> addition = new ArrayList<>();

		String subMsg;
		int offset = 0;
		int index;
		while (offset < msg.length()) {
			subMsg = msg.substring(offset);
			index = getDictionaryIndex(subMsg, addition);
			result.add(index);

			if (offset == msg.length() - 1) {
				break;
			}

			if (index < 27) {
				addition.add(subMsg.substring(0, 2));
				offset++;
			} else {
				int length = addition.get(index - 27).length();
				if (length == subMsg.length()) {
					break;
				}
				addition.add(subMsg.substring(0, length + 1));
				offset += length;
			}
		}

		return result.stream()
				.mapToInt(r -> r)
				.toArray();
	}

	private int getDictionaryIndex(String msg, List<String> addition) {
		int index = msg.charAt(0) - 'A' + 1;
		for (int i = 0; i < addition.size(); i++) {
			if (msg.startsWith(addition.get(i))) {
				index = i + 27;
			}
		}
		return index;
	}

}
