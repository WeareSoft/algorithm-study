package hackerrank;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * Fraudulent Activity Notifications
 * https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 */
public class FraudulentActivityNotifications {
    public static void main(String[] args) {
//        System.out.println(activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));
//        System.out.println(activityNotifications(new int[]{10, 20, 30, 40, 50}, 3));
        System.out.println(activityNotifications(new int[]{1, 2, 3, 4, 4}, 4));
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
            if (expenditure[i] < median*2) {
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
        for (int i = 0; i < arr.length; i++) {
            if (cnt > d / 2) {
                if (isEven) {
                    if (cnt == d) {
                        for (int j = i; j < arr.length; j++) {
                            if (arr[j] != 0) {
                                return (i + j) / 2;
                            }
                        }
                    } else {
                        return i;
                    }
                } else { // odd
                    return i - 1;
                }
            }
            cnt += arr[i];
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
