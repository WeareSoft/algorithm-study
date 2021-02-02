package dami.programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/12985

public class 예상_대진표 {
	public int solution(int n, int a, int b) {
		int round = 1;
		while (divide(a) != divide(b)) {
			a = divide(a);
			b = divide(b);
			round++;
		}

		return round;
	}

	private int divide(int a) {
		return (a + 1) / 2;
	}
}

/*  // 다른 풀이

public int solution(int n, int a, int b)
{
    return Integer.toBinaryString((a-1)^(b-1)).length();
}

*/
