package dami.hackerrank.medium;

import java.util.HashMap;
import java.util.Map;

public class The_Time_in_Words {
	private static final String O_CLOCK = " o' clock";
	private static final String MINUTES = " minutes";
	private static final String TO = " to ";
	private static final String PAST = " past ";
	private static final Map<Integer, String> intToWordMap = new HashMap<>();

	static {
		intToWordMap.put(1, "one");		intToWordMap.put(2, "two");		intToWordMap.put(3, "three");
		intToWordMap.put(4, "four");		intToWordMap.put(5, "five");		intToWordMap.put(6, "six");
		intToWordMap.put(7, "seven");		intToWordMap.put(8, "eight");		intToWordMap.put(9, "nine");
		intToWordMap.put(10, "ten");		intToWordMap.put(11, "eleven");		intToWordMap.put(12, "twelve");
		intToWordMap.put(13, "thirteen");		intToWordMap.put(14, "fourteen");		intToWordMap.put(15, "quarter");
		intToWordMap.put(16, "sixteen");		intToWordMap.put(17, "seventeen");		intToWordMap.put(18, "eighteen");
		intToWordMap.put(19, "nineteen");		intToWordMap.put(20, "twenty");		intToWordMap.put(21, "twenty one");
		intToWordMap.put(22, "twenty two");		intToWordMap.put(23, "twenty three");		intToWordMap.put(24, "twenty four");
		intToWordMap.put(25, "twenty five");		intToWordMap.put(26, "twenty six");        intToWordMap.put(27, "twenty seven");
		intToWordMap.put(28, "twenty eight");		intToWordMap.put(29, "twenty nine");        intToWordMap.put(30, "half");
	}

	public String timeInWords(int h, int m) {
		if (m == 0) {
			return intToWordMap.get(h) + O_CLOCK;
		}

		boolean isOver30 = false;
		if (m > 30) {
			isOver30 = true;
			h = (h + 1) % 12;
			m = 60 - m;
		}

		if (isOver30) {
			return intToWordMap.get(m) + getMinutes(m) + TO + intToWordMap.get(h);
		}

		return intToWordMap.get(m) + getMinutes(m) + PAST + intToWordMap.get(h);
	}

	private String getMinutes(int m) {
		return ((m != 15 && m != 30) ? m == 1 ? MINUTES.substring(0, MINUTES.length()-1) : MINUTES : "");
	}
}
