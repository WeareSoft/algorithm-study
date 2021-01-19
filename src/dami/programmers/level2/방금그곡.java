package dami.programmers.level2;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/17683

// 주의할 점 1. C# D# F# G# A# 등 #음은 한 개 음으로 취급하기
// 주의할 점 2. LocalTime 의 minusMinutes()는 시간 고려하지 않고 단순 minutes 차이만 계산
//              Duration의 between() 활용
// 주의할 점 3. 재생시간까지 동일한 경우 먼저 입력된 음악을 반환해야하므로 순서 보장하는 LinkedHashMap 사용
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
		Map<String, String> playInfo = new LinkedHashMap<>();
		for (String musicinfo : musicinfos) {
			String[] info = musicinfo.split(",");

			int playTime = getPlayTime(info[0], info[1]);
			System.out.println(playTime);
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
		return (int) (Duration.between(startLdt, endLdt).getSeconds() / 60);
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
