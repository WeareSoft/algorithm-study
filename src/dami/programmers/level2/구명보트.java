package dami.programmers.level2;

import java.util.Arrays;

public class 구명보트 {
	public int solution(int[] people, int limit) {
		Arrays.sort(people);

		int count = 0;
		int i = 0, j = people.length - 1;
		while (i < j) {
			int on = people[i] + people[j];
			if (on <= limit) {
				i++;
			}
			j--;
			count++;
		}

		if (i == j) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// 50 50 70 80 // if limit is 240 then answer is 2
		// 오름차순 정렬해서 맨 앞이랑 맨 뒤랑 더해조야 하나...? 둘이 합해서 limit 도달 안하는 케이스일 경우, 맨 뒤 인덱스를 앞으로 하나씩 옮겨주기?
		// 맨 앞부터 시작하는 인덱스, 맨 뒤부터 시작하는 인덱스 두개 가지고 점점 가운데로 모아야 하남...
		System.out.println(new 구명보트().solution(new int[]{10,20,30,40,50,60,70,80,90}, 100)); // 5
		System.out.println(new 구명보트().solution(new int[]{10,20,30,40,50,60,70,80,90}, 90)); // 5
		System.out.println(new 구명보트().solution(new int[]{40,40,60,70}, 90)); // 3
		System.out.println(new 구명보트().solution(new int[]{40,40,50,60,70}, 90)); // 4
	}
}
