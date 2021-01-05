package dami.programmers.level2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/17683

// C# D# F# G# A#
// 재생 시간이 악보 길이보다 짧을 경우 고려하기 (m이 악보의 끝부분과 일치할 때)
// #음은 한 개 음으로 취급하기
public class 방금그곡 {
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
		String convertedM = convertSharpNote(m);
		Map<String, String> playInfo = new HashMap<>();
		for (String musicinfo : musicinfos) {
			String[] info = musicinfo.split(",");

			int playTime = getPlayTime(info[0], info[1]);
			playInfo.put(info[2], getFullPlayNotes(info[3], playTime));
		}

		return playInfo.keySet().stream()
				.sorted((key1, key2) -> playInfo.get(key2).length() - playInfo.get(key1).length())
				.filter(key -> playInfo.get(key).contains(convertedM))
				.findFirst()
				.orElse("(None)");
	}

	private int getPlayTime(String start, String end) {
		LocalTime startLdt = LocalTime.parse(start, DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime endLdt = LocalTime.parse(end, DateTimeFormatter.ofPattern("HH:mm"));
		return endLdt.minusMinutes(startLdt.getMinute()).getMinute();
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
}
