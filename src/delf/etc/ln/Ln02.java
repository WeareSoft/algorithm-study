package etc.ln;

/**
 * @author delf
 */
public class Ln02 {
	public static void main(String[] args) {
		System.out.println(new Ln02().solution("4132315142", new String[]{"3241523133", "4121314445", "3243523133", "4433325251", "2412313253"}));
		System.out.println(new Ln02().solution("53241", new String[]{"53241", "42133", "53241", "14354"}));
		System.out.println(new Ln02().solution("24551", new String[]{"24553", "24553", "24553", "24553"}));
	}

	public int solution(String answerSheet, String[] sheet) {
		int maxCheatProbabilityIndex = 0;
		for (int p1 = 0; p1 < sheet.length - 1; p1++) {
			for (int p2 = p1 + 1; p2 < sheet.length; p2++) {
				// p1과 p2의 '부정행위 가능성 지수' 계산
				int totalDoubtCount = 0;
				int longestDoubtCount = 0;
				int doubtCount = 0;
				for (int q = 0; q < answerSheet.length(); q++) {
					if (sheet[p1].charAt(q) == sheet[p2].charAt(q) && sheet[p1].charAt(q) != answerSheet.charAt(q)) {
						doubtCount++;
						totalDoubtCount++;
					} else {
						doubtCount = 0;
					}
					longestDoubtCount = Math.max(longestDoubtCount, doubtCount);
				}
				// 최댓값 기록
				int cheatProbabilityIndex = totalDoubtCount + (int) Math.pow(longestDoubtCount, 2);
				maxCheatProbabilityIndex = Math.max(maxCheatProbabilityIndex, cheatProbabilityIndex);
			}
		}

		return maxCheatProbabilityIndex;
	}
}
