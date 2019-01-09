package hee.boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Hee_Q1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void run() throws IOException {
        String[] strings = br.readLine().split(" ");
        int K = Integer.parseInt(strings[0]); // 가지고 있는 랜선의 개수
        int N = Integer.parseInt(strings[1]); // 필요한 랜선의 개수

        ArrayList<Integer> arrayList = new ArrayList(); // 가지고 있는 랜선의 길이
        while (K-- > 0) {
            int num = Integer.parseInt(br.readLine());
            arrayList.add(num);
        }
        Collections.sort(arrayList); // 오름차순 정렬


        long maxX = arrayList.get(arrayList.size() - 1); // X의 최댓값(랜선의 길이 중 최대 길이)
        long minX = 1; // X의 최솟값(랜선의 길이는 자연수)

        /* 이진 탐색(Binary Search) 이용 */
        // shares >= N을 만족하는 N의 최댓값
        while (minX <= maxX) {
            long midX = (maxX + minX) / 2;
            int shares = sumOfShares(arrayList, midX); // mid로 나눈 몫의 합

            if(shares >= N){ // N개 이상 만들 수 있으면 X를 증가
                minX = midX + 1;
            } else { // N개를 만들 수 없으면 X를 감소
                maxX = midX - 1;
            }
        }
        System.out.println(maxX);
    }

    // arrayList의 값들을 X로 나눈 몫의 합
    public static int sumOfShares(ArrayList<Integer> arrayList, long X) {
        int res = 0;

        for(int i=0; i<arrayList.size(); i++) {
            res += arrayList.get(i) / X;
        }
        return res;
    }

}


