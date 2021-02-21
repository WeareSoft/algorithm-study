package hackerrank;

import java.util.*;

/**
 * Fraudulent Activity Notifications
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 */
public class FraudulentActivityNotifications {
    public static void main(String[] args) {
//        System.out.println(activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));
        System.out.println(activityNotifications(new int[]{10, 20, 30, 40, 50}, 3));
//        System.out.println(activityNotifications(new int[]{1, 2, 3, 4, 4}, 4));
        // 1 2 3 4 4

    }

    static int activityNotifications(int[] expenditure, int d) {
        int fraudulentCnt = 0;

        int[] nums = new int[201];
        for (int i = 0; i < d; i++) {
            nums[expenditure[i]]++;
        }
        System.out.println(Arrays.toString(nums));

        for (int i = d; i < expenditure.length; i++) {
            int median = getMedian(nums, d);
            System.out.println(expenditure[i] + " " + median * 2);
            if (expenditure[i] < median * 2) {
                fraudulentCnt++;
            }
            nums[expenditure[d]]++;
            nums[expenditure[i - d]]--;
        }
        return fraudulentCnt;
    }

    private static int getMedian(int[] arr, int d) {
        final boolean isEven = d % 2 == 0;
        int cnt = 0;
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            cnt += arr[i];
            tmp = i;
            if (cnt >= d / 2) {
                if (isEven) {
                    if (cnt == d / 2) {
                        System.out.println("#1");
                        return (i + tmp) / 2;
                    }
                    System.out.println("#2");
                    return i - 1;
                } else { // odd
                    if (cnt == d / 2) {
                        System.out.println("#3");
                        return i;
                    }
                    System.out.println("#4");
                    return i + 1;
                }
            }
            /*if (cnt > d / 2) {
                System.out.println(String.format("cnt=%d, d/2=%d", cnt, d / 2));
                if (isEven) {
                    System.out.println("even!");
                    if (cnt == d / 2) {
                        for (int j = i + 1; j < arr.length; j++) {
                            if (arr[j] != 0) {
                                System.out.println(String.format("i=%d, j=%d", i, j));
                                return (i + j) / 2;
                            }
                        }
                    } else {
                        return i;
                    }
                } else { // odd
                    return i - 1;
                }
            }*/
        }
        throw new IllegalArgumentException();
    }


    static int activityNotifications2(int[] expenditure, int d) {
        int fraudulentCnt = 0;
        for (int i = 0; i < expenditure.length - d; i++) {
            int[] copied = Arrays.copyOfRange(expenditure, i, i + d);
            System.out.println(Arrays.toString(copied));
            Arrays.sort(copied);
            int median = getMedian2(copied, d);
            System.out.println(median);
            if (expenditure[i + d] < median * 2) {
                fraudulentCnt++;
            }
        }
        return fraudulentCnt;
    }

    private static int getMedian2(int[] copied, int d) {
        final boolean isOdd = d % 2 != 0;
        if (isOdd) {
            return copied[d / 2];
        } else {
            return (copied[(d / 2) - 1] + copied[d / 2]) / 2;
        }
    }
}
