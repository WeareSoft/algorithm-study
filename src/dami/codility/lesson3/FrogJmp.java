package dami.codility.lesson3;

// 문제 : https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
// 결과 : https://app.codility.com/demo/results/trainingZW2P29-72A/
public class FrogJmp {
	public int solution(int X, int Y, int D) {
		int total = Y - X;
		return (total / D) + (total % D != 0 ? 1 : 0);
	}
}
