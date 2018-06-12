package doy.sort;

import java.util.*;

public class Doy_Q2751 {
    // N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    // 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절대값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
    // 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
    static Scanner s = new Scanner(System.in);

    public static void run() {
        int t = s.nextInt();
        List<Integer> num = new ArrayList<>();

        for(int i=0; i<t; i++){
            num.add(s.nextInt());
        }

        Collections.sort(num);

        for(int i=0; i<t; i++){
            System.out.println(num.get(i));
        }
    }
}


/*
    Collections.sort()와 Arrays.sort()가 어떤 차이가 있는지(성능적으로나 알고리즘으로는 어떤 것이 더 많이 쓰이는지)에 대해 조사하여 다음 스터디에서 서로 공유합시다.
    변수명을 조금 더 의미 있게 지으면 좋을 거 같네요 :)
    반복문에서 사용하는 변수 말고 int t 말고 수의 개수를 표현할만한 변수명이면 좋겠어요~
*/
