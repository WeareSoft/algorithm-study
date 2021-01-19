package programmers;

import java.util.*;

/**
 * 오픈 채팅방
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */
public class Solution42888 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution42888().solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
	}

	private final static String ENTER_LOG_FORMAT = "%s님이 들어왔습니다.";
	private final static String LEAVE_LOG_FORMAT = "%s님이 나갔습니다.";

	private final Map<String, User> map = new HashMap<>();

	public String[] solution(String[] record) {
		List<String> answer = new ArrayList<>();
		for (String value : record) {
			String[] split = value.split(" ");
			switch (split[0]) {
				case "Enter":
					map.put(split[1], new User(split[1], split[2]));
					break;
				case "Leave":
					leave(split[1]);
					break;
				case "Change":
					map.get(split[1]).setName(split[2]);
			}
		}


		for (String s : record) {
			String[] split = s.split(" ");
			switch (split[0]) {
				case "Enter":
					answer.add(map.get(split[1]).getEnterLog());
					break;
				case "Leave":
					answer.add(map.get(split[1]).getLeaveLog());
					break;
			}
		}

		return answer.toArray(new String[0]);
	}

	private void leave(String uid) {
		map.get(uid).setConnected(false);
	}

	class User {
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isConnected() {
			return isConnected;
		}

		public void setConnected(boolean connected) {
			isConnected = connected;
		}

		private String uid;
		private String name;
		private boolean isConnected;

		public User(String uid, String name) {
			this.uid = uid;
			this.name = name;
			this.isConnected = true;
		}

		public String getEnterLog() {
			return String.format(ENTER_LOG_FORMAT, getName());
		}

		public String getLeaveLog() {
			return String.format(LEAVE_LOG_FORMAT, getName());
		}
	}
}
