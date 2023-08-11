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

	public int solution_2023(int n) {
		int answer = 0;
		while (n > 0) {
			if (n % 2 == 1) {
				answer++;
			}
			n /= 2;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new 점프와_순간_이동().solution_2023(5000));
	}
}
