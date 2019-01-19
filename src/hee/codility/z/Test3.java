package hee.codility.z;

import java.util.LinkedHashMap;

public class Test3 {
    public int solution(int[] A) {
        if (A.length < 2) {
//            System.out.println(A.length);
//            return;
            return A.length;
        }

        LinkedHashMap<Integer, Integer> nums = new LinkedHashMap();
        nums.put(A[0], 0); // num, startIdx

        int maxLength = 1, length = 1;
        for (int i = 1; i < A.length; i++) {
            if (nums.containsKey(A[i])) { /* 이미 존재하는 숫자인 경우 */
                ++length; // 길이 증가
                nums.remove(A[i]); // 순서 유지를 위해 해당 숫자(인덱스 변경됨)를 삭제 후 다시 추가
            } else { /* 새로운 숫자인 경우 */
                if (nums.size() == 2) { // 이미 서로 다른 숫자가 2개인 경우
                    length = i - nums.get(nums.keySet().toArray()[0]); // 길이 변경
                    nums.remove(nums.keySet().toArray()[0]); // 첫 번째 숫자 제거 후 새로운 숫자 추가
                } else { // 새로운 나머지 하나의 숫자인 경우
                    ++length; // 길이 증가, 새로운 숫자 추가
                }
            }
            nums.put(A[i], i);

            // 최대 길이 변경
            if (maxLength < length) {
                maxLength = length;
            }
        }
//        System.out.println(maxLength);
        return maxLength;
    }
}
