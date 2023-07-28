package dami.programmers.level2;

import java.util.*;

public class 영어_끝말잇기 {
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		int number;
		Set<String> wordSet = new HashSet<>();
		for (int i = 0; i < words.length; i++) {
			number = i + 1;
			String word = words[i];
			if (wordSet.contains(word) || (i > 0 && !words[i - 1].endsWith(word.substring(0, 1)))) {
				if (number % n == 0) {
					answer[0] = n;
					answer[1] = number / n;
				} else {
					answer[0] = number % n;
					answer[1] = number / n + 1;
				}
				return answer;
			}
			wordSet.add(word);
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] answer = new 영어_끝말잇기().solution(2, new String[]{"land", "dream", "mom", "mom", "ror"});
		System.out.println(Arrays.toString(answer));
	}
}
