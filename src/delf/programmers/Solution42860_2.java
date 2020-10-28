package programmers;

/**
 * @author delf
 */
public class Solution42860_2 {
	public static void main(String[] args) {
//		System.out.println(new Solution42860().solution("AABAAAAAAAB"));
//		System.out.println(new Solution42860().solution("JEROEN"));
		System.out.println(">>>>>> " + new Solution42860_2().solution("BBBBAAAABA"));
		System.out.println(">>>>>> " + new Solution42860_2().solution("BBBBAAAAAB"));
		System.out.println(">>>>>> " + new Solution42860_2().solution("AABAAAAAAABBB"));
		System.out.println(">>>>>> " + new Solution42860_2().solution("AAB"));
		System.out.println(">>>>>> " + new Solution42860_2().solution("CANAAAAANAN"));
	}

	public int solution(String name) {
		return recursive(name.toCharArray(), 0);
	}

	private int recursive(char[] name, int index) {
		char[] arr = name.clone();
		int upDownCnt = Math.min(arr[index] - 'A', Math.abs('Z' - arr[index] + 1));
		arr[index] = 'A';

		int right = 0;
		for (int i = 1; i < arr.length; i++) {
			int ci = (index + i) < arr.length ? index + i : (index + i) % arr.length;
			if (arr[ci] != 'A') {
				right += (recursive(arr, ci) + i);
				break;
			}
		}

		int left = 0;
		for (int i = 1; i < arr.length; i++) {
			int ci = (index - i) < 0 ? (index - i + arr.length) % arr.length : index - i;
			if (arr[ci] != 'A') {
				left += (recursive(arr, ci) + i);
				break;
			}
		}
		return Math.min(left, right) + upDownCnt;
	}
}
