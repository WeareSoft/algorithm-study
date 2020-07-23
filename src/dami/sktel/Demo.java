package dami.sktel;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 배열 A의 값 목록에 없는 양의 정수 중 가장 작은 값 반환
 *
 */

public class Demo {
	public int solution(int[] A) {

		Set<Integer> set = new HashSet<>();

		for(int a : A) {
			set.add(a);
		}

		for(int i=1; i<Integer.MAX_VALUE; i++) {
			if(!set.contains(i)) {
				return i;
			}
		}

		return -1;

	}

}
