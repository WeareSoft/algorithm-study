package hee.nhn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hee_1809_Q3 {
    static int days;
    static ArrayList<Integer> price;
    static int coin = 0;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        days = sc.nextInt();

        price = new ArrayList();
        for (int i = 0; i < days; i++) {
            price.add(sc.nextInt());
        }

        int money = 0;
        for (int i = 0; i < days; i++) {
            int todayPrice = price.remove(0);
            int maxPrice = 0;

            if (!price.isEmpty())
                maxPrice = Collections.max(price);

            if (todayPrice < maxPrice) { // 산다.(최대 1개 구매 가능)
                System.out.println("산다.");
                money = money - todayPrice;
                coin++;
            } else { // 팔지 아무것도 안할지 정한다.
                if (todayPrice == maxPrice) { // 아무것도 안한다.
                    System.out.println("아무것도 안한다.");
                    continue;
                }
                // 코인이 있으면 판다.
                if (coin > 0) {
                    System.out.println("판다.");
                    money = money + (todayPrice * coin) - 1; // 수수료 1원
                    coin = 0;
                }
            }
        }
        System.out.println(money);
    }
}

