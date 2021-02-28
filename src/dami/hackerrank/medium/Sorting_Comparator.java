package dami.hackerrank.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sorting_Comparator {
	public void solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		Player[] player = new Player[n];
		Checker checker = new Checker();

		for(int i = 0; i < n; i++){
			player[i] = new Player(scan.next(), scan.nextInt());
		}
		scan.close();

		Arrays.sort(player, checker);
		for (Player value : player) {
			System.out.printf("%s %s\n", value.name, value.score);
		}
	}
}

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {
	// complete this method
	public int compare(Player a, Player b) {
		if (a.score == b.score) {
			return a.name.compareTo(b.name);
		}

		return b.score - a.score;
	}
}
