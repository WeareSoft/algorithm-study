package dami.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// 테스트 케이스
// "I", "III", "IV", "IX", "LVIII", "MCMXCIV", "MMMCMXCIX"
public class Roman_to_Integer_13 {
	private final static Map<String, Integer> romanMap = new HashMap<>();

	static {
		romanMap.put("I", 1);
		romanMap.put("V", 5);
		romanMap.put("X", 10);
		romanMap.put("L", 50);
		romanMap.put("C", 100);
		romanMap.put("D", 500);
		romanMap.put("M", 1000);
	}

	public int romanToInt(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			int current = romanMap.get(String.valueOf(s.charAt(i)));
			int next = i+1 == s.length() ? 0 : romanMap.get(String.valueOf(s.charAt(i+1)));

			if (current < next) {
				sum += next - current;
				i++;
				continue;
			}
			sum += current;
		}

		return sum;
	}
}
