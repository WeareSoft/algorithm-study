package dami.leetcode.medium;

import java.util.*;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// 주어진 문자열에서 가장 긴 중복 없는 문자열 길이 구하기
// 영문자, 숫자, 특수문자, 스페이스 공백 포함

// 1. 주어진 문자열을 char array로 분리
// 2. array만큼 반복하면서 List에 추가하기 전에 List에 현재값 있는지 확인
//  없으면 List에 추가
//  있으면 현재위치까지 문자열 길이 계산해서 최댓값 비교

// 처음에는 중복 문자까지 리스트를 자를 때 charList = subList로 했는데 속도가 매우 느렸음 1668ms..ㄷㄷ
// 찾아보니 subList할 때는 new ArrayList<>(subList);를 해야 속도 개선 가능
//  [참고] https://m.blog.naver.com/PostView.nhn?blogId=yjw2288&logNo=221072561904&proxyReferer=https:%2F%2Fwww.google.com%2F
// 변경 후 11ms로 줄었지만.. 그래도 느림
// 가장 빠른 방법은 하단 다른 풀이 1, 2 확인
public class Longest_Substring_3 {
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		char[] string = s.toCharArray();
		List<Character> charList = new ArrayList<>();
		for (char c : string) {
			if (!charList.contains(c)) {
				charList.add(c);
				max = Math.max(max, charList.size());
				continue;
			}

			int length = charList.indexOf(c) + 1; // 0부터 중복값 index까지 길이이자 다음 문자열의 offset
			charList.add(c);
			charList = new ArrayList<>(charList.subList(length, charList.size()));
			max = Math.max(max, length);
		}

		return max;
	}
}

/* // 다른 풀이 1
	public int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()==0)
			return 0;
		int maxL=1;
		int start =0;
		char [] arr = s.toCharArray();
		for(int end=0;end<arr.length;end++){
			int temp=start;
			while(temp<end){
				if(arr[temp]==arr[end]){
					temp++;
					start=temp;
					break;
				}
				temp++;
			}
			maxL = Math.max(maxL, end-start+1);
		}
		return maxL;

	}
*/

/* // 다른 풀이 2
	public int lengthOfLongestSubstring(String s) {
        int l=0;
        int start=0;
        int[] arr=new int[128];
        for(int i=0;i<s.length();i++){
            start=Math.max(arr[s.charAt(i)],start);
            l=Math.max(l, i-start+1);
            arr[s.charAt(i)]=i+1;
        }
        l=Math.max(l, s.length()-start);
        return l;
    }
*/
