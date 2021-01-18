package programmers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * 셔틀 버스
 * https://programmers.co.kr/learn/courses/30/lessons/17678
 */
public class Solution17678 {

	public static void main(String[] args) {
		System.out.println(new Solution17678().solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
//		System.out.println(new Solution17678().solution(1, 1, 5, new String[]{"08:01", "08:04", "08:02", "08:03"}));
	}


	public String solution(int n, int t, int m, String[] timetable) {
		Arrays.sort(timetable);

		LocalTime nextBusTime = LocalTime.parse("09:00", DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime lastBusTime = nextBusTime.minusHours(1).plusMinutes(n * t);
		System.out.println(lastBusTime);
		int crew = 0;
		for (String time : timetable) {
			System.out.println(nextBusTime + " " + crew);
			if (nextBusTime.isAfter(lastBusTime) || nextBusTime.equals(lastBusTime)) {
				break;
			}

			if (crew > m) {
				crew = 0;
				continue;
			}

			if (nextBusTime.toString().compareTo(time) > 0) {
				crew++;
				continue;
			}

			nextBusTime = nextBusTime.plusMinutes(t);
		}

		if (!nextBusTime.equals(lastBusTime)) {
			return lastBusTime.toString();
		}

		if (crew < m) {
			return lastBusTime.toString();
		}

		return lastBusTime.toString();
	}

}
