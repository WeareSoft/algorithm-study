package programmers;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

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
        Queue<LocalTime> queue = new PriorityQueue<>();
        for (String value : timetable) {
            if (value.equals("24:00")) {
                value = "23:59";
            }
            queue.add(LocalTime.parse(value, DateTimeFormatter.ofPattern("HH:mm")));
        }
        LocalTime bus = LocalTime.parse("09:00", DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime corn = LocalTime.parse("09:00", DateTimeFormatter.ofPattern("HH:mm"));

        for (int i = 0; i < n; i++) {
            int people = 0;
            for (int j = 0; j < m; j++) {
                if (!queue.isEmpty()) {
                    if (bus.isAfter(queue.peek()) || bus.equals(queue.peek())) {
                        corn = queue.poll();
                        people++;
                    }
                }
                if (i == n - 1 && people == m) {
                    corn = corn.minusMinutes(1);
                } else if (i == n - 1 && people < m) {
                    corn = bus;
                }
            }
            bus = bus.plusMinutes(t);
        }
        return corn.toString();
    }

    public String solution2(int n, int t, int m, String[] timetable) {
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

        return lastBusTime.toString();
    }

}
