package doy;

import java.math.BigInteger;
import java.util.*;

public class Doy_Q11652 {
    // 준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 ***-2(62)보다 크거나 같고, 2(62)보다 작거나 같다.***
    // 준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 만약, 가장 많이 가지고 있는 정수가 여러가지라면, 작은 것을 출력한다.
    public static Scanner s = new Scanner(System.in);
    public static void run() {
        int inputCount = s.nextInt();
        List<BigInteger> list = new ArrayList<>();

        for(int i=0; i<inputCount; i++) {
            list.add(s.nextBigInteger());
        }

        Collections.sort(list);

        int curCount=1, maxCount=1;
        BigInteger res = list.get(0);
        for(int i=0; i<inputCount-1; i++) {
            if(list.get(i).equals(list.get(i+1))) {
                curCount++;
            }
            else {
                curCount = 1;
            }

            if(curCount > maxCount) {
                maxCount = curCount;
                res = list.get(i);
            }
        }
        System.out.println(res);
    }
}
