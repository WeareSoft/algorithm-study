package programmers;

/**
 * 조이스틱
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 */
public class Solution42860 {
	public int solution(String name) {
		int answer = -1;

		for (char ch : name.toCharArray()) {
			answer += (Math.min(ch - 'A', Math.abs('Z' - ch + 1)) + 1);
		}

		int preA = 0;
		for (int i = 1; i < name.length(); i++) {
			if (name.charAt(i) != 'A') {
				break;
			}
			preA++;
		}

		int postA = 0;
		for (int i = name.length() - 1; i >= 1; i--) {
			if (name.charAt(i) != 'A') {
				break;
			}
			postA++;
		}
		return answer - Math.max(preA, postA);
	}

	public static void main(String[] args) {
		System.out.println(new Solution42860().solution("AABAAAAAAAB"));
	}
}
