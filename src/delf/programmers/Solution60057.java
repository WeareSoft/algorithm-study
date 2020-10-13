package programmers;

/**
 * 문자열 압축
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class Solution60057 {

	public static void main(String[] args) {
//		System.out.println(new Solution60057().solution("abcabcabcabcdededededede"));
		System.out.println(new Solution60057().solution("abcabcdede"));
	}

	public int solution(String s) {
		int answer = s.length();
		for (int i = 1; i <= s.length() / 2; i++) { // 반복은 최대 length/2
			String result = press(s, i);
			answer = Math.min(answer, result.length());
		}

		return Math.min(answer, press(s, s.length()).length()); // 반복이 없는 경우 = 반복 문자열이 자기 자신(전체) 하나인 경우
	}

	private static String press(String s, int n) {
		StringBuilder sb = new StringBuilder(); // 성능을 고려해야했다면, 쓰지 않았을 것 (숫자만 카운팅)
		for (int i = 0; i <= s.length() - n; i += n) {
			String target = s.substring(i, i + n); // 성능을 고려해야했다면, 쓰지 않았을 것 (캐릭터 단위로 직접비교)
			int count = 1;
			for (int j = i + n; j <= s.length() - n; j += n) {
				if (!target.equals(s.substring(j, j + n))) {
					break;
				}
				i = j; // 비교하는 문자가 같다면, 다음 target 재설정
				count++;
			}
			if (count > 1) {
				sb.append(count); // 반복이 존재하면 숫자 붙이고
			}
			sb.append(target); // 해당 문자열 붙이기
		}
		sb.append(s.substring(s.length() - (s.length() % n)));
		return sb.toString();
	}
}
