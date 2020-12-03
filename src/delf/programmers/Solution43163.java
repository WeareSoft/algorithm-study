package programmers;

/**
 * 단어 변환
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 */
public class Solution43163 {
	private String[] words;

	public int solution(String begin, String target, String[] words) {
		this.words = words;//new ArrayList<>(Arrays.asList(words));
		boolean[] isVisit = new boolean[words.length];
		return dfs(begin, target, isVisit, 0);
	}


	private int dfs(String begin, String target, boolean[] isVisit, int depth) {
		if (begin.equals(target)) {
			return 0;
		}

		int min = words.length;
		for (int i = 0; i < words.length; i++) {
			if(isVisit[i]) {
				continue;
			}

			if (hasNext(begin, words[i])) {
//                System.out.println(begin + " -> " + words[i]);
				isVisit[i] = true;
				int tmp = dfs(words[i], target, isVisit, depth);
				isVisit[i] = false;
				min = Math.min(min, tmp + 1);
			}
		}

		return min;
	}

	private boolean hasNext(String begin, String target) {
		boolean hasNext = false;
		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) != target.charAt(i)) {
				if (hasNext) {
					return false;
				}
				hasNext = true;
			}
		}
		return hasNext;
	}
}
