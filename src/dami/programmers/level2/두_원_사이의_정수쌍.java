package dami.programmers.level2;

public class 두_원_사이의_정수쌍 {

	public long solution(int r1, int r2) {
		int bigDiameter = Math.max(r1, r2) * 2;
		int smallDiameter = Math.min(r1, r2) * 2;
		return (long) (Math.pow(bigDiameter - 1, 2) - Math.pow(smallDiameter - 1, 2) + 4);
	}
}
