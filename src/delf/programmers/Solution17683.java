package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 방금 그곡
 * https://programmers.co.kr/learn/courses/30/lessons/17683
 */
public class Solution17683 {
	public String solution(String m, String[] musicinfos) {

		Map<String, String> map = new HashMap<>();
		for (String musicinfo : musicinfos) {
			String[] info = musicinfo.split(",");
			int timeDiff = getTimeDiff(info[0], info[1]);
			map.put(getMelodyPlayed(info[3], timeDiff), info[2]);
		}

		for (String melody : map.keySet()) {
			if (contains(melody, m)) {

			}
		}
		return "";
	}

	private boolean contains(String melody, String search) {
		int index = 0;
		while (index > -1) {
			index = melody.indexOf(search, index);
		}

		return false;
	}

	private String getMelodyPlayed(String score, int playTime) {
		String melody = "";
		for (int i = 0; i < playTime; i++) {
			String note = Character.toString(score.charAt(i % (score.length() - 1)));
			char next = score.charAt((i + 1) % (score.length() - 1));
			if (next == '#') {
				note += next;
				i++;
			}
			melody += note;
		}
		return melody;
	}

	private int getTimeDiff(String start, String end) {
		String[] startTime = start.split(":");
		String[] endTime = end.split(":");


		int startMinute = Integer.valueOf(startTime[0]);
		int startSecond = Integer.valueOf(startTime[1]);

		int endMinute = Integer.valueOf(endTime[0]);
		int endSecond = Integer.valueOf(endTime[1]);

		return (endMinute - startMinute) * 60 + (endSecond - startSecond);
	}

	public static void main(String[] args) {
		String s = "ABCDEDF";
		System.out.println(s.indexOf("CD"));
//		System.out.println(new Solution17683().solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
	}
}
