package dami.programmers.level3.review;

import java.time.LocalTime;
import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/17678

// 1. timetable 정렬
// 2. 마지막 버스 탑승자 목록 구하기
//  2-1. 마지막 전 버스들 만큼 탑승자 처리하고
//	2-2. 마지막 버스 첫 탑승자 인덱스 구하기
// 3. 마지막 탑승자 번호가 최대인원이면 맨 마지막 탑승자시간보다 -1분 == 콘 도착시간
//      else 버스 시간 == 콘 도착시간
public class 셔틀버스 {
	private static final String FIRST_BUS = "09:00";

	public String solution(int n, int t, int m, String[] timetable) {
		Arrays.sort(timetable);

		LocalTime busTime = LocalTime.parse(FIRST_BUS);

		int firstPersonOfLastBus = 0;
		for (int i = 0; i < n - 1 && firstPersonOfLastBus < timetable.length - 1; i++) {
			int currentM = m;
			while (busTime.toString().compareTo(timetable[firstPersonOfLastBus]) >= 0 && currentM > 0) {
				firstPersonOfLastBus++;
				currentM--;
			}
			busTime = busTime.plusMinutes(t);
		}

		int lastPersonOfLastBus = firstPersonOfLastBus;
		int currentM = m;
		while (lastPersonOfLastBus < timetable.length - 1 && busTime.toString().compareTo(timetable[lastPersonOfLastBus]) >= 0 && currentM > 0) {
			lastPersonOfLastBus++;
			currentM--;
		}

		String result;
		if (busTime.toString().compareTo(timetable[lastPersonOfLastBus]) >= 0 && lastPersonOfLastBus - firstPersonOfLastBus == m - 1) {
			result = LocalTime.parse(timetable[lastPersonOfLastBus]).minusMinutes(1).toString();
		} else {
			result = busTime.toString();
		}
		return result;
	}

}
