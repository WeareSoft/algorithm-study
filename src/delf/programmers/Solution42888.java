package programmers;

import java.util.*;

/**
 * 오픈 채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */
public class Solution42888 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("abc");
		System.out.println(sb.replace(1, 2, "s").toString());


//		System.out.println(Arrays.toString(new Solution42888().solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
	}

	private final static String ENTER_LOG_FORMAT = "%s님이 들어왔습니다.";
	private final static String LEAVE_LOG_FORMAT = "%s님이 나갔습니다.";

	private final Map<String, String> map = new HashMap<>();

	public String[] solution(String[] record) {
		List<String> answer = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		sb.replace(1, 2, "S");


		for (String value : record) {
			String[] split = value.split(" ");
			switch (split[0]) {
				case "Enter":
				case "Change":
					map.put(split[1], split[2]);
					break;
			}
		}

		for (String s : record) {
			String[] split = s.split(" ");
			switch (split[0]) {
				case "Enter":
					answer.add(String.format(ENTER_LOG_FORMAT, map.get(split[1])));
					break;
				case "Leave":
					answer.add(String.format(LEAVE_LOG_FORMAT, map.get(split[1])));
					break;
			}
		}

		return answer.toArray(new String[0]);
	}
}
