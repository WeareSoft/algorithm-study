package dami.programmers.level2;


// https://programmers.co.kr/learn/courses/30/lessons/70129

// 1. 주어진 문자열(이진수 문자열)에서 replaceAll 사용해서 0 없애고, 문자열 길이 비교로 제거한 0개수 확인
// 2. 1의 개수를 이진수 문자열로 변환
// 1, 2 반복
public class 이진_변환_반복하기 {
	public int[] solution(String s) {
		int oneCount = s.length();
		int zeroCount = 0;
		int iteration = 0;
		while (!(oneCount == 1 && s.contains(("1")))) {
			iteration++;
			oneCount = s.replaceAll("0", "").length();
			if (s.contains("0")) {
				zeroCount += s.length() - oneCount;
			}
			s = convertBinaryString(oneCount);
		}

		return new int[] {iteration, zeroCount};
	}

	private String convertBinaryString(int number) {
		StringBuilder result = new StringBuilder();
		int remain;
		while (number > 1) {
			remain = number % 2;
			number /= 2;
			result.insert(0, remain);
		}
		result.insert(0,  number);
		return result.toString();
	}


	public static void main(String[] args) {
		new 이진_변환_반복하기().solution_2023("111111");
	}


	public int[] solution_2023(String s) {
		int numberOfConvert = 0;
		int numberOfZero = 0;
		while (!s.equals("1")) {
			int originLength = s.length();
			String removedS = s.replaceAll("0", "");
			numberOfZero += originLength - removedS.length();

			s = Integer.toBinaryString(removedS.length());
			numberOfConvert++;
		}

		return new int[] {numberOfConvert, numberOfZero};
	}
}
