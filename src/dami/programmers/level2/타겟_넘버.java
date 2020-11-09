package dami.programmers.level2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/43165?language=java

// 1. 주어진 배열의 총 합 계산
// 2. '총 합 - 타겟 값'이 각 원소의 누적 두 배 값과 같으면 결과 + 1 (총 합 - 원소 두 배 값(누적) == 타겟인 경우 찾기)
//  보다 크면 총 합에서 원소 두 배 값 빼주고 다음값과 비교하도록 재귀 호출

// 다른 풀이와 유사하지만 나는 로직을 꼬아서 푼 듯
public class 타겟_넘버 {
	public int solution(int[] numbers, int target) {
		int sum = Arrays.stream(numbers).sum();
		return recursive(sum - target, 0, numbers, 0);
	}

	private int recursive(int currentSum, int currentIndex, int[] numbers, int result) {
		if (currentSum == 0) {
			return result + 1;
		}

		for (int i = currentIndex; i < numbers.length; i++) {
			if (currentSum >= numbers[i] * 2 ) {
				result = recursive(currentSum - numbers[i] * 2, i + 1, numbers, result);
			}
		}

		return result;
	}
}
/* // 다른 풀이
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
*/
