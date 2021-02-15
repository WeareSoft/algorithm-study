package dami.programmers.level3;

// https://programmers.co.kr/learn/courses/30/lessons/60059?language=java

// 1. 자물쇠 왼쪽 상단 모서리부터 오른쪽 하단 모서리 한 칸까지 이동할 수 있는 큰 배열 생성
// 2. 자물쇠 홈 좌표 목록 기록
// 3. 키를 왼쪽 상단 모서리 한 칸 위치부터 이동시키면서 자물쇠 전체가 1로 채워졌는지 확인 (구해둔 좌표 목록만 확인)
// 4. 키가 오른쪽 하단 모서리 한 칸 위치까지 돌고 자물쇠 풀리지 않으면 90도 회전
public class 자물쇠와_열쇠 {
	private static final int CHECK_COUNT = 4; // 네 방향

	public boolean solution(int[][] key, int[][] lock) {
		int lockSize = lock.length;

		// 열쇠 이동시킬 큰 판 수식 : 2(keySize - 1) + lock
		int bigSize = 2 * (key.length - 1) + lock.length;
		int start = bigSize / lockSize;

		int[][] bigArray = new int[bigSize][bigSize];
		for (int i = start; i < start + lockSize ; i++) {
			for (int j = start; j < start + lockSize; j++) {
				bigArray[i][j] = lock[i - start][j - start];
			}
		}

		for (int checkCount = 0; checkCount < CHECK_COUNT; checkCount++) { // 4번 회전

			for (int i = 0; i <= bigSize - key.length; i++) { // 큰 판에서 key 이동 가능한 만큼 반복
				for (int j = 0; j <= bigSize - key.length; j++) {
					if (isOpen(bigArray, start, lockSize, key, i, j)) {
						return true;
					}
				}
			}

			key = rotate(key);
		}

		return false;
	}

	private boolean isOpen(int[][] bigArray, int lockStart, int lockSize, int[][] key, int bigI, int bigJ) {
		int[][] openedLock = new int[lockSize][lockSize];

		for (int i = lockStart; i < lockStart + lockSize; i++) {
			for (int j = lockStart; j < lockStart + lockSize; j++) {
				openedLock[i - lockStart][j - lockStart] += bigArray[i][j];
				// 자물쇠랑 키 겹치는 범위 + key
				if (i - bigI >= 0 && i - bigI < key.length && j - bigJ >= 0 && j - bigJ < key.length) {
					openedLock[i - lockStart][j - lockStart] += key[i - bigI][j - bigJ];
				}

				if (openedLock[i - lockStart][j - lockStart] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	private int[][] rotate(int[][] key) {
		int length = key.length;
		int[][] rotated = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				rotated[i][j] = key[length - 1 - j][i];
			}
		}
		return rotated;
	}
}
