package dami.programmers.level2;

//https://programmers.co.kr/learn/courses/30/lessons/12980

public class 점프와_순간_이동 {

	public int solution(int n) {
		int result = 0;

		while (n > 1) {
			if (n % 2 != 0) {
				result++;
			}
			n /= 2;
		}

		return ++result;
	}
}
