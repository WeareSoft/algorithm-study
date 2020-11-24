package programmers;

/**
 * @author delf
 */
public class Solution42885 {
	public static void main(String[] args) {
		System.out.println(new Solution42885().solution(new int[]{70, 50, 80, 50}, 100));
	}

	public int solution(int[] people, int limit) {
		int answer = Integer.MAX_VALUE;


		for (int adj = 0; adj < people.length; adj++) {
			int count = 0;
			boolean[] isCrossed = new boolean[people.length];
			for (int p1 = 0; p1 < people.length; p1++) {
				int adjP1 = (p1 + adj) % people.length;
				if (isCrossed[adjP1]) {
					continue;
				}
				isCrossed[adjP1] = true;
				count++;
				for (int p2 = p1 + 1; p2 < people.length; p2++) {
					int adjP2 = (p2 + adj) % people.length;
					if (isCrossed[adjP2] || adjP1 == adjP2) {
						continue;
					}
					if (people[adjP1] + people[adjP2] <= limit) {
						isCrossed[adjP2] = true;
						break;
					}
				}
			}
			answer = Math.min(answer, count);
		}

		return answer;
	}
}
