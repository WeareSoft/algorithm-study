package dami.programmers.level2;

// ** 이해 제대로 못함
// 나머지 0일 때 왜 몫에서 1 빼야 하는건지? 나머지, 124나라 값이랑 몫 규칙순서 맞출라고??
/**
 *
 *  10진법     목(/3)       나머지(%3)     124나라
 * ------------------------------------------------
 *  1           0           1               1
 *  2           0           2               2
 *  3           1           0               4
 *  4           1           1               11
 *  5           1           2               12
 *  6           2           0               14
 *  7           2           1               21
 *  8           2           2               22
 *  9           3           0               24
 *  10          3           1               41
 *
 */
public class 일이사_나라의_숫자 {
	public String solution(int n) {
		StringBuilder answer = new StringBuilder();

		int remain = 0;
		while (n != 0) {
			remain = n % 3;
			n = (n - 1) / 3;

			answer.append("412".charAt(remain));
		}

		return answer.reverse().toString();
	}

	/*  // 다른 풀이
		public String solution(int n) {
			String[] num = {"4","1","2"};
			String answer = "";

			while(n > 0){
				answer = num[n % 3] + answer;
				n = (n - 1) / 3;
			}
			return answer;
		}
	 */
}
