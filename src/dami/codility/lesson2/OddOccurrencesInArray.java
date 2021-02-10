package dami.codility.lesson2;

// 문제 : https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
// 결과 : https://app.codility.com/demo/results/trainingPGQRXT-CDK/
public class OddOccurrencesInArray {
	public int solution(int[] A) {
		int result = 0;
		for (int num : A) {
			result ^= num;
		}

		return result;
	}

}
