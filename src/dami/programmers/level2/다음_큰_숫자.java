package dami.programmers.level2;

public class 다음_큰_숫자 {
	public int solution_timeout(int n) {
		int answer = 0;
		String binary = Integer.toBinaryString(n);
		int oneCount = binary.replaceAll("0", "").length();

		for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
			int nextNumberOneCount = 0;
			char[] binaryChars = Integer.toBinaryString(i).toCharArray();
			for (char binaryChar : binaryChars) {
				if (binaryChar == '1') {
					nextNumberOneCount++;
				}
			}
			if (nextNumberOneCount == oneCount) {
				return i;
			}
		}

		return answer;
	}

	public int solution(int n) {
		int oneCount = getOneCount(n);

		for (int answer = n + 1; answer < Integer.MAX_VALUE; answer++) {
			if (getOneCount(answer) == oneCount) {
				return answer;
			}
		}
		return 0;
	}

	private int getOneCount(int num) {
		int oneCount = 0;
		int o = num;
		while (o > 0) {
			if (o % 2 == 1) {
				oneCount++;
			}
			o = o / 2;
		}

		return oneCount;
	}



	public int solution_fail(int n) {
		int answer = 0;

		int[] oneCounts = new int[n];
		for (int i = 1; i <= n; i++) {
			oneCounts[i - 1] = Integer.toBinaryString(i).replaceAll("0", "").length();
		}

		int oneCount = oneCounts[n];
		for (int i = n / 2; i < oneCounts.length; i++) {
			if (oneCount == oneCounts[i]) {
				return i * 2 - 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new 다음_큰_숫자().solution(15));
		//new 다음_큰_숫자().solution_fail(73);
	}
}
