package hee.boj;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Hee_Q1094 {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        /* [방법1] */
        System.out.println(Integer.bitCount(x));

        /* [방법2] */
//		int stick = 64;
//		int res = 0;
//		while (x > 0) {
//			while (stick > x)
//				stick /= 2;
//			x = x - stick;
//			res++;
//		}
//		System.out.println(res);

        /* [방법3] */
//		ArrayList<Integer> subStick = new ArrayList();
//		int stick = 64;
//		subStick.add(64);
//		int res = 1;
//		while (true) {
//			if (stick == 0)
//				break;
//
//			int sum = 0;
//			for (int i = 0; i < subStick.size(); i++)
//				sum += subStick.get(i);
//
//			if (sum > x) {
//				subStick.remove(subStick.size() - 1);
//				stick /= 2;
//				subStick.add(stick);
//				continue;
//			} else if (sum < x) {
//				stick /= 2;
//				subStick.add(stick);
//				res++;
//			} else {
//				break;
//			}
//		}
//		System.out.println(res);

    }
}
