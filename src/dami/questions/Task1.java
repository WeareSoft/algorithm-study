package dami.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Task1 {
	private Map<Character, Integer> taggerCounts;
	private Participants participants;

	public void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) {
		initGame(numOfAllPlayers);
		char tagger = 'A';
		int taggerPos = 0;

		for (int i = 0; i < numOfGames; i++) {
			// (현재 술래 위치 + 이동 칸수) % 앉아있는 참여자 수
			taggerPos = (taggerPos + numOfMovesPerGame[i]) % (numOfAllPlayers - 1);
			if (taggerPos < 0) {
				taggerPos += (numOfAllPlayers - 1);
			}

			taggerCounts.put(tagger, taggerCounts.get(tagger) + 1);
			if (!participants.isFaster(taggerPos, namesOfQuickPlayers)) {
				tagger = participants.changeTagger(taggerPos, tagger);
			}
		}
		taggerCounts.put(tagger, taggerCounts.get(tagger) + 1);

		printGame();
	}

	private void initGame(int numOfAllPlayers) {
		participants = new Participants(numOfAllPlayers);
		taggerCounts = new HashMap<>();
		for (int i = 0; i < participants.size(); i++) {
			taggerCounts.put(participants.getName(i), 0);
		}
		taggerCounts.put('A', 0);
	}

	private void printGame() {
		for (int i = 0; i < participants.size(); i++) {
			System.out.println(participants.getName(i) + " " + taggerCounts.get(participants.getName(i)));
			taggerCounts.remove(participants.getName(i));
		}
		taggerCounts.forEach((key, value) -> System.out.println(key + " " + value));
	}
}

class Participants {
	private final char[] names;

	public Participants(int num) {
		names = new char[num - 1];
		for (int i = 0; i < num - 1; i++) {
			names[i] = (char)('B' + i);
		}
	}

	public char getName(int index) {
		return names[index];
	}

	public int size() {
		return names.length;
	}

	public boolean isFaster(int index, char[] names) {
		return IntStream.range(0, names.length)
				.mapToObj(i -> names[i])
				.anyMatch(name -> name == this.names[index]);
	}

	public char changeTagger(int index, char tagger) {
		char temp = names[index];
		names[index] = tagger;
		return temp;
	}
}
