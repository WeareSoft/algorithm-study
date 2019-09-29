package hee.leetcode;

public class Counting_Bits_338 {

    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        } else if (num == 1) {
            return new int[]{0, 1};
        }

//        int[] result = new int[num + 1];
//        result[0] = 0;
//        result[1] = 1;
//
//        for (int i = 2; i < result.length; i++) {
//            // &: 두 비트 모두 1일 떄 1로 세팅 후 이진수를 십진수로 변환하여 return
//            result[i] = result[i & (i - 1)] + 1;
//            System.out.println("test: " + (i & (i - 1)));
//            System.out.println(result[i & (i - 1)]);
//        }
//        return result;

        int[] res = new int[num + 1];
        res[0] = 0;
        int next = 2; int prev = 0;

        for (int i = 1; i < res.length; i++) {
            if (i == next) {
                res[i] = 1;
                prev = next;
                next = next * 2;
            } else {
                res[i] = 1 + res[i - prev];
            }
        }
        return res;
    }
}
