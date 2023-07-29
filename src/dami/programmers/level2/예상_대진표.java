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

	// 1+0, 0+1 / 1+1, 0+2 / 1+2, 0+3
	// 1 2 3 4 5 6 7 8
	public int solution_2023(int n, int a, int b) {
		int exponent = log2(n);
		for (int round = 1; round <= exponent; round++) {
			if ((a%2 + a/2) == (b%2 + b/2)) {
				return round;
			}
			a = a%2 + a/2;
			b = b%2 + b/2;
		}
		return 1;
	}

	private int log2(int value) {
		return (int) (Math.log(value) / Math.log(2));
	}

	public static void main(String[] args) {
		System.out.println(new 예상_대진표().solution(2, 1, 2));
	}

}

/*  // 다른 풀이

// (a-1) XOR (b-1)값을 이진수 문자열로 변환한 길이를 세는 거니까. 예를들어 3과 7이면 11 XOR 111이고 값은 100이 되니까 문자열 길이가 바로 3라운드가 되겠네요.
public int solution(int n, int a, int b)
{
    return Integer.toBinaryString((a-1)^(b-1)).length();
}

*/
