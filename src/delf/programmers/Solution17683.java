package programmers;

import java.util.Map;
import java.util.TreeMap;

/**
 * 방금 그곡
 * https://programmers.co.kr/learn/courses/30/lessons/17683
 */
public class Solution17683 {
	public String solution(String m, String[] musicinfos) {

		Map<String, String> map = new TreeMap<>((o1, o2) -> o2.length() - o1.length());

		for (String musicinfo : musicinfos) {
			String[] info = musicinfo.split(",");
			int timeDiff = getTimeDiff(info[0], info[1]);
			map.put(getMelodyPlayed(info[3], timeDiff), info[2]);
		}

		System.out.println(map);

		for (String melody : map.keySet()) {
			if (contains(melody, m)) {
				return map.get(melody);
			}
		}

		return "(None)";
	}

	private boolean contains(String melody, String search) {
		if (search.endsWith("#")) {
			return melody.contains(search);
		}

		int index = 0;
		while (true) {
			index = melody.indexOf(search, index);
			if (index == -1) {
				return false;
			}
			index += search.length();
			System.out.println(melody.charAt(index));
			if (melody.charAt(index) != '#') {
				return true;
			}
		}
	}

	private String getMelodyPlayed(String score, int playTime) {
		StringBuilder melody = new StringBuilder();
		for (int i = 0; i < playTime; i++) {
			String note = Character.toString(score.charAt(i % score.length()));
			char next = score.charAt((i + 1) % score.length());
			if (next == '#') {
				note += next;
				i++;
			}
			melody.append(note);
		}
		return melody.toString();
	}

	private int getTimeDiff(String start, String end) {
		String[] startTime = start.split(":");
		String[] endTime = end.split(":");

		int startMinute = Integer.valueOf(startTime[0]);
		int startSecond = Integer.valueOf(startTime[1]);

		int endMinute = Integer.valueOf(endTime[0]);
		int endSecond = Integer.valueOf(endTime[1]);

		return 60 * (endMinute - startMinute) + (endSecond - startSecond);
	}

	public static void main(String[] args) {
//		String s = "ABCDEDHSFWAEFDF";
//		System.out.println(s.indexOf("ABCDEDHSFWAEFDF"));
		System.out.println(new Solution17683().solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
		System.out.println(new Solution17683().solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
		System.out.println(new Solution17683().solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));

	}
}
