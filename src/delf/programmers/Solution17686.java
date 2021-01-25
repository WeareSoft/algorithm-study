package programmers;

import java.util.*;
import java.util.regex.Pattern;

/**
 * [3차] 파일명 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/17686
 */
public class Solution17686 {
	public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution17686().solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
        System.out.println(Arrays.toString(new Solution17686().solution(new String[]{"a 001.ee", "A1.zz", "a01.33"})));
		System.out.println(new FileName("abc123.jpg"));

	}

	public String[] solution(String[] files) {
		String[] answer = new String[files.length];
		FileName[] fileNames = new FileName[files.length];
		for (int i = 0; i < fileNames.length; i++) {
			fileNames[i] = new FileName(files[i]);
		}

		Arrays.sort(fileNames);

		for (int i = 0; i < fileNames.length; i++) {
			answer[i] = fileNames[i].origin;
		}
		return answer;
	}

	static class FileName implements Comparable<FileName> {
		private String origin;

		private String head = "";
		private int number = -1;

		@Override
		public String toString() {
			return "FileName{" +
					"origin='" + origin + '\'' +
					", head='" + head + '\'' +
					", number=" + number +
					'}';
		}

		public FileName(String origin) {
			this.origin = origin;

			for (int i = 0; i < origin.length(); i++) {
				char ch = origin.charAt(i);

				if (head.isEmpty()) {
					if (Character.isDigit(ch)) {
						head = origin.substring(0, i).toLowerCase();
					}
				} else {
					if (!Character.isDigit(ch)) {
						int endIndex = i - head.length() > 5 ? head.length() + 5 : i;
						number = Integer.parseInt(origin.substring(head.length(), endIndex));
						break;
					}
				}
			}
			if (number == -1) {
				int endIndex = origin.length() - head.length() > 5 ? head.length() + 5 : origin.length();
				number = Integer.parseInt(origin.substring(head.length(), endIndex));
			}
		}

		@Override
		public int compareTo(FileName o) {
			if (this.head.equals(o.head)) {
				if (this.number == o.number) {
					return 1;
				}
				return Integer.compare(this.number, o.number);
			}
			return this.head.compareTo(o.head);
		}
	}
}
