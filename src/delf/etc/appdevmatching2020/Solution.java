package etc.appdevmatching2020;


import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public int solution(long n) {
		long tmp = n;
		int cnt = 0;
		Set<Long> set = new HashSet<>();
		do {
			long div = n % 10;
			if (div != 0 && !set.contains(div) && tmp % (div) == 0) {
				cnt++;
			}
			set.add(div);
		} while ((n /= 10) > 0);

		return cnt;
	}
}
