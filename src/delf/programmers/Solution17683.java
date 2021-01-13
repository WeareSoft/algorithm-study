package programmers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 방금 그곡
 * https://programmers.co.kr/learn/courses/30/lessons/17683
 */
public class Solution17683 {
	private static final Map<String, String> sharp;

	static {
		sharp = new HashMap<>();
		sharp.put("C#", "c");
		sharp.put("D#", "d");
		sharp.put("F#", "f");
		sharp.put("G#", "g");
		sharp.put("A#", "a");
	}

	public String solution(String m, String[] musicinfos) {
//		Map<String, String> playInfo = new LinkedHashMap<>();
		List<String> titles = new ArrayList<>();
		List<String> melodys = new ArrayList<>();
		for (String musicinfo : musicinfos) {
			String[] info = musicinfo.split(",");

			int playTime = getPlayTime(info[0], info[1]);
			titles.add(info[2]);
			melodys.add(getFullPlayNotes(info[3], playTime));
		}

		String convertedMelody = convertSharpNote(m);
		int maxMelodyLength = 0;
		String maxMelodyTitle = "";
		for (int i = 0; i < titles.size(); i++) {
			String melody = melodys.get(i);
			if (melody.contains(convertedMelody))
				if (melody.length() > maxMelodyLength) {
					maxMelodyLength = melody.length();
					maxMelodyTitle = titles.get(i);
				}
		}

		return maxMelodyTitle.equals("") ? "(None)" : maxMelodyTitle;
	}

	static private int getPlayTime(String start, String end) {
		LocalTime startLdt = LocalTime.parse(start, DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime endLdt = LocalTime.parse(end, DateTimeFormatter.ofPattern("HH:mm"));
		return endLdt.minusMinutes(startLdt.getMinute()).getMinute();
	}

	static private int getTimeDiff(String start, String end) {
		String[] startTime = start.split(":");
		String[] endTime = end.split(":");

		int startMinute = Integer.valueOf(startTime[0]);
		int startSecond = Integer.valueOf(startTime[1]);

		int endMinute = Integer.valueOf(endTime[0]);
		int endSecond = Integer.valueOf(endTime[1]);

		return (endMinute - startMinute) * 60 + (endSecond - startSecond);
	}

	private String getFullPlayNotes(String notes, int playTime) {
		StringBuilder fullNotes = new StringBuilder();
		notes = convertSharpNote(notes);
		for (int i = 0; i < playTime / notes.length(); i++) {
			fullNotes.append(notes);
		}
		fullNotes.append(notes, 0, playTime % notes.length());

		return fullNotes.toString();
	}


	private String convertSharpNote(String notes) {
		for (String key : sharp.keySet()) {
			notes = notes.replaceAll(key, sharp.get(key));
		}
		return notes;
	}

	public static void main(String[] args) {
//		String s = "ABCDEDHSFWAEFDF";
//		System.out.println(s.indexOf("ABCDEDHSFWAEFDF"));
//		System.out.println(new Solution17683().solution("ABC", new String[]{"13:00,13:06,JJ,CCABCD", "13:00,13:06,WORLD,ABCDEF", "12:00,12:14,HELLO,A",}));
//		System.out.println(new Solution17683().solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
//		System.out.println(new Solution17683().solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
		String start = "11:00";
		String end = "24:00";

		System.out.println(getPlayTime(start, end));
		System.out.println(getTimeDiff(start, end));
	}
}
