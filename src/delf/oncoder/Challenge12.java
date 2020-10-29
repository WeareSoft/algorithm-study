package oncoder;

/**
 * 대선 전략 수립
 * https://www.oncoder.com/ground/SkmYcmk1E
 */
public class Challenge12 {
	public int solution(String[] stats){
		double minRatio = 1;
		int minStat = 0;
		for (int i = 0; i < stats.length; i++) {
			int one = 0;
			int two = 0;
			for (char ch : stats[i].toCharArray()) {
				if (ch == '1') {
					one++;
					continue;
				}
				two++;
			}
			double ratio = (double) one / (double) (one + two);
			if (minRatio > ratio) {
				minRatio = ratio;
				minStat = i;
			}
		}
		return minStat;
	}

	public static void main(String[] args) {
		System.out.println(new Challenge12().solution(new String[]{"111", "112", "121", "122", "211", "212", "221", "222"}));
	}
}
