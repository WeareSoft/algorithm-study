package dami.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 추억_점수 {

	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];

		Map<String, Integer> yearningRank = new HashMap<>();
		for (int i = 0; i < name.length; i++) {
			yearningRank.put(name[i], yearning[i]);
		}

		int i = 0;
		for (String[] currentPhoto : photo) {
			int sum = 0;
			for (String personName : currentPhoto) {
				sum += yearningRank.getOrDefault(personName, 0);
			}
			answer[i++] = sum;
		}

		return answer;
	}
}
