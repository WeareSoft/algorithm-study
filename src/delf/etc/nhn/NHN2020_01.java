package etc.nhn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NHN2020_01 {

	public static void main(String[] args) {
//		new NHN2020_01().solution(6, new char[]{'B', 'C'}, new int[]{3, -2});
		new NHN2020_01().solution(17, new char[]{'B', 'D', 'I', 'M', 'P'}, new int[]{3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23});
	}

	public void solution(int numOfAllPlayers, char[] namesOfQuickPlayers, int[] numOfMovesPerGame) {
		/* 세팅 */
		List<Character> playerInCircle = new ArrayList<>(); // 둘러 앉은 플레이어 List
		Map<Character, Integer> counter = new HashMap<>(); // 술래 카운터 Map
		for (int i = 0; i < numOfAllPlayers - 1; i++) {
			playerInCircle.add((char) ('B' + i)); // 앉은 플레이어 세팅 (A제외)
		}

		int towelPosition = 0; // 수건의 위치(= 술래가 수건을 놓은 위치 = 술래의 출발 위치)
		char taggerThisRound = 'A'; // 현 라운드 술래
		counter.merge(taggerThisRound, 1, Integer::sum); // 초기 술래 카운팅

		/* 라운드만큼 시뮬레이팅 */
		for (int move : numOfMovesPerGame) {
			/* 수건을 놓은 위치(= 다음 술래 후보) 계산 */
			towelPosition = nextTargetPosition(numOfAllPlayers - 1, towelPosition, move);
			char target = playerInCircle.remove(towelPosition);

			/* 다음 술래와 생존자 계산 */
			char nextTagger = witchIsTagger(taggerThisRound, target, namesOfQuickPlayers);
			char survivor = (nextTagger == taggerThisRound) ? target : taggerThisRound;
			playerInCircle.add(towelPosition, survivor); // 리스트 정리

			counter.merge(nextTagger, 1, Integer::sum); // 술래 카운팅
			taggerThisRound = nextTagger; // 다음 라운드 술래 지정
		}

		/* 출력 */
		for (char ch : playerInCircle) {
			System.out.println(String.format("%c %d", ch, counter.getOrDefault(ch, 0)));
		}
		System.out.println(String.format("%c %d", taggerThisRound, counter.getOrDefault(taggerThisRound, 0)));
	}

	private int nextTargetPosition(int numOfCirclePlayer, int startIdx, int move) {
		int result = startIdx + move;
		return result < 0 ? (result + numOfCirclePlayer) % numOfCirclePlayer : result % numOfCirclePlayer;
	}

	private char witchIsTagger(char tagger, char target, char[] namesOfQuickPlayers) {
		for (char ch : namesOfQuickPlayers) {
			if (ch == target) {
				return tagger;
			}
		}
		return target;
	}
}
