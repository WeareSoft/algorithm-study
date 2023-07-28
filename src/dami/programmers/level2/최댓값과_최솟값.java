package dami.programmers.level2;

public class 최댓값과_최솟값 {
	public String solution(String s) {
		String[] integers = s.split(" ");

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (String integer : integers) {
			min = Math.min(min, Integer.parseInt(integer));
			max = Math.max(max, Integer.parseInt(integer));
		}

		return min + " " + max;
	}
}
