package programmers;

/**
 * 짝지어 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12973
 */
public class Solution12973 {
	public static void main(String[] args) {
		System.out.println(new Solution12973().solution("cdcd"));
		System.out.println(new Solution12973().solution("baabaa"));
	}

	public int solution(String s) {
		int answer = 0;
		int flagIdx = 0;

		int cur = 1;
		int gap = 0;
		do {
			if (s.charAt(flagIdx) != s.charAt(cur)) {
				flagIdx += (gap + 1);
				gap = 0;
			} else {
				if (gap == 0) {
					flagIdx--;
				} else {
					flagIdx += (gap + 1);
				}
				gap += 2;
				answer++;
			}
			cur++;
		} while (flagIdx < s.length() - 1);

		return answer;
	}
}
