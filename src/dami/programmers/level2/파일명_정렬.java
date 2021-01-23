package dami.programmers.level2;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

// https://programmers.co.kr/learn/courses/30/lessons/17686

// 정렬 기준에 따라 차이가 없다면 원래 입력에서 주어진 순서를 유지하는 안정 정렬
// 안정 정렬 O : 병합, 버블, 삽입
// 안정 정렬 X : 퀵
// C++과 Python에는 안정 정렬이 있고, Java와 JavaScript, Swift에는 안정 정렬이 없음
// 안정 정렬을 지원하지 않거나, 이 문제처럼 비교 조건이 까다로운 경우에는 decorate-sort-undecorate 패턴을 이용해서 쉽게 해결할 수도

// 1. key는 파일명, value는 각각 head와 number를 가지는 headMap, numberMap 생성
// 2. 각각 head와 number부 분리해서 저장
// 3. 조건에 맞게 정렬해서 결과 반환
public class 파일명_정렬 {
	private static final int MAX_NUMBER_SIZE = 5;
	private static final String NUMBER = Pattern.compile("[0-9]{1,5}").pattern();
	private static final String CHARACTER = Pattern.compile("[\\sa-z.-]").pattern();

	public String[] solution(String[] files) {
		Map<String, String> headMap = new LinkedHashMap<>();
		Map<String, Integer> numberMap = new LinkedHashMap<>();
		for (String file : files) {
			String[] split = file.split(NUMBER);
			headMap.put(file, split[0].toLowerCase());
			numberMap.put(file, splitNumber(file, split));
		}

		return headMap.keySet().stream()
				.sorted((key1, key2) -> {
					if (headMap.get(key1).equals(headMap.get(key2))) {
						return numberMap.get(key1) - numberMap.get(key2);
					}
					return headMap.get(key1).compareTo(headMap.get(key2));
				})
				.toArray(String[]::new);
	}

	// 1. 숫자부분 Math.min(문자열 길이, 5)자리까지 자르기
	// 2. 숫자 정규식으로 문자 목록 분리한 String 배열 크기가 1인 경우 (img000, img0000000) 그대로 반환
	// 3. 배열 크기가 2 이상인 경우 문자 정규식으로 숫자 목록 분리한 배열의 첫번째 값 반환
	private Integer splitNumber(String file, String[] split) {
		String numberString = file.substring(split[0].length(), Math.min(file.length(), MAX_NUMBER_SIZE + split[0].length()));
		if (split.length < 2) {
			return Integer.parseInt(numberString);
		}

		return Integer.parseInt(numberString.split(CHARACTER)[0]);
	}

}


/* // 다른 풀이. Matcher 클래스 활용

class Solution {
  public String[] solution(String[] files) {
        List<FileName> fileNameList = new ArrayList<>();
        String head, number, tail;

        for (int i = 0; i < files.length; i++) {
            String s = files[i];
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(s);
            if (m.find()){
                number = m.group();
                int numberStartIndex = s.indexOf(number);
                head = s.substring(0, numberStartIndex);
                int numberEndIndex = numberStartIndex + number.length() - 1;
                if (numberEndIndex + 1 > s.length() - 1) {
                    tail = "";
                } else {
                    tail = s.substring(numberEndIndex + 1);
                }
                fileNameList.add(new FileName(head, number, tail));
            }
        }

        fileNameList.sort(Comparator.comparing(FileName::getHead).thenComparing(Comparator.naturalOrder()));

        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = fileNameList.get(i).toString();
        }
        return answer;
    }

    public static class FileName implements Comparable<FileName> {
        String head;
        String number;
        String tail;

        public FileName(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String getHead() {
            return head.toUpperCase();
        }

        @Override
        public String toString() {
            return head + number + tail;
        }

        @Override
        public int compareTo(FileName o) {
            int mine = Integer.parseInt(this.number);
            int yours = Integer.parseInt(o.number);
            return mine - yours;
        }
    }
}

*/


/*  // 다른 풀이

class Solution {
  public String[] solution(String[] files) {
      Arrays.sort(files, new StrCmp());
      return files;
  }
  private class StrCmp implements Comparator<String> {
      @Override
      public int compare(String s1, String s2) {
          s1 = s1.toLowerCase();
          s2 = s2.toLowerCase();

          // 문자열 비교
          int i = 0;
          int j = 0;
          while (i < s1.length() && !Character.isDigit(s1.charAt(i))) ++i;
          while (j < s2.length() && !Character.isDigit(s2.charAt(j))) ++j;
          int cmp1 = s1.substring(0, i).compareTo(s2.substring(0, j));
          if (cmp1 != 0) return cmp1;

          // 숫자 비교
          int startI = i;
          int startJ = j;
          while (i < s1.length() && Character.isDigit(s1.charAt(i))) ++i;
          while (j < s2.length() && Character.isDigit(s2.charAt(j))) ++j;
          int num1 = Integer.parseInt(s1.substring(startI, i));
          int num2 = Integer.parseInt(s2.substring(startJ, j));
          return num1 - num2;
      }
  }
}

*/
