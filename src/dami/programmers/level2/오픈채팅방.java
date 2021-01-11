package dami.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/42888
public class 오픈채팅방 {
	private static final String[] COMMAND = new String[]{"Enter", "Leave", "Change"};
	private static final Map<String, String> MESSAGES = new HashMap<>();
	static {
		MESSAGES.put("Enter", "님이 들어왔습니다");
		MESSAGES.put("Leave", "님이 나갔습니다.");
	}

	public String[] solution(String[] record) {
		Map<String, String> userMap = new HashMap<>();
		List<StringBuilder> results = new ArrayList<>();

		for (String r : record) {
			String[] line = r.split(" ");
			if (!line[0].equals(COMMAND[1])) {
				userMap.put(line[1], line[2]);
			}

			if (!line[0].equals(COMMAND[2])) {
				results.add(new StringBuilder(line[1] + MESSAGES.get(line[0])));
			}
		}

		for (StringBuilder result : results) {
			int uidLength = result.indexOf("님");
			result.replace(0, uidLength, userMap.get(result.substring(0, uidLength)));
		}

		return results.stream()
				.map(StringBuilder::toString)
				.toArray(String[]::new);
	}
}
