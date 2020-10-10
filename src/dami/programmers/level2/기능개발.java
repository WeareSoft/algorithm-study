package dami.programmers.level2;

import java.util.ArrayList;
import java.util.List;

// 1. 배포 일 수 배열 구하기
// 2. 배포 일 수 배열 크기만큼 반복
//  - 다음 값이 현재 값보다 작으면 count++
//  - 다음 값이 현재 값보다 크면 턴 넘기기
public class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {

		int[] deploys = new int[progresses.length];
		for (int i = 0; i < progresses.length; i++) {
			int maybeDeploy = 100 - progresses[i];
			if (speeds[i] == 1) {
				deploys[i] = maybeDeploy;
				continue;
			}
			deploys[i] = maybeDeploy / speeds[i] + (maybeDeploy % speeds[i] == 0 ? 0 : 1);
		}

		int i = 1;
		int current = 0;
		List<Integer> answer = new ArrayList<>();
		for (; i < deploys.length; i++) {
			if (deploys[current] < deploys[i]) {
				answer.add(i - current);
				current = i;
			}
		}
		answer.add(i - current);
		return answer.stream().mapToInt(a -> a).toArray();
	}
}
