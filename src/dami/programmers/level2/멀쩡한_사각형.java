package dami.programmers.level2;

// 1. 두 수의 최대공약수 구하기
// 2. 두 수에 최대공약수로 나눠서 나온 수로 만들어진 작은 직사각형의 대각선 커팅 시 잘린 사각형 개수 구하기
//   - 최대 공약수가 1인 두 수로 만들어진 직사각형의 잘린 사각형 개수 = 가로 + 세로 - 1
// 3. 잘린 사각형 개수 * 최대공약수 = 처음에 주어진 두 수로 만들어진 직사각형의 전체 잘린 사각형 개수
// ** 계산 시 형변환 주의 **

// - 수식 정리
// 가로 W, 세로 H, W와 H의 최대공약수 gcd
// gcd로 나눈 가로 w, 세로 h (w, h의 최대공약수는 1)
// 멀쩡한 사각형 계산식 : W * H - (w + h - 1) * gcd
// == W * H - (W + H - gcd)

// #### 최대공약수 구하는 방법
// - 유클리드 호제법 활용
// - 유클리드 호제법은 mod 연산으로 사용 가능
// ** mod 연산? : 두 값을 나눈 나머지를 구하는 연산

/**
 * ex. 1112와 695의 최대공약수 구하기
 * 1112 mod 695 = 417
 * 695 mod 417 = 278
 * 417 mod 278 = 139
 * 278 mod 139 = 0
 * ==> 139가 1112와 695의 최대공약수
  */
public class 멀쩡한_사각형 {
	public long solution(int w, int h) {
		return ((long)w * h) - (w + h - calculateGcd(w, h));
	}

	private int calculateGcd(int w, int h) {
		if (h > w) {
			int temp = w;
			w = h;
			h = temp;
		}

		int remainder;
		while (h != 0) {
			remainder = w % h;
			w = h;
			h = remainder;
		}
		return w;
	}
}
