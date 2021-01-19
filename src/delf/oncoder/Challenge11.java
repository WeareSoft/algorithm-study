package oncoder;

/**
 * 잔액 계산
 * https://www.oncoder.com/ground/rJjZchpRX
 */
public class Challenge11 {
	public int solution(int balance, String[] transactions) {
		for (String tr : transactions) {
			String[] args = tr.split(" ");
			String cmd = args[0];
			int amount = Integer.parseInt(args[1]);

			if (cmd.equals("C")) {
				balance += amount;
				continue;
			}

			balance -= amount;
		}
		return balance;
	}
}
