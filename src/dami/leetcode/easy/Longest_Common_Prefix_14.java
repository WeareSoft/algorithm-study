package dami.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

// 1. 주어진 배열에서 가장 짧은 단어 추출
// 2. 가장 짧은 단어 길이만큼 반복
//  - 가장 짧은 단어 앞에서부터 한 개씩 substring 하고 나머지 배열 값 중 같은 문자열 개수 확인
//  - 같은 문자열 개수가 3개 미만이면 이전 문자까지 자른 prefix 반환
// 3. 반복문 끝까지 같은 문자열 개수 3개이면 가장 짧은 문자열 반환
public class Longest_Common_Prefix_14 {
	public String longestCommonPrefix(String[] strs) {
		String shortestWord = shortestWordInArray(strs);
		for (int i = 1; i <= shortestWord.length(); i++) {
			String substring = shortestWord.substring(0, i);
			long count = Arrays.stream(strs)
					.filter(str -> str.startsWith(substring))
					.count();
			if (count != strs.length) {
				return substring.substring(0, i-1);
			}
		}
		return shortestWord;
	}

	private String shortestWordInArray(String[] strs) {
		return Arrays.stream(strs)
				.min(Comparator.comparing(String::length))
				.orElse("");
	}
}


/*
	// 빠른 속도 답
	if(strs.length == 0) return "";

    for(int i = 0; i<strs[0].length();i++){
        char c = strs[0].charAt(i);
        for(int j = 1; j<strs.length;j++){
            if(i == strs[j].length() || strs[j].charAt(i) != c){
                return strs[0].substring(0,i);
            }

        }
    }
    return strs[0];
*/
