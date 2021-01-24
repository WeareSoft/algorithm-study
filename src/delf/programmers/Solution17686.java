package programmers;

import java.util.*;

/**
 * [3차] 파일명 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/17686
 */
public class Solution17686 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution17686().solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(new Solution17686().solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
        System.out.println(Arrays.toString(new Solution17686().solution(new String[]{"a 001.ee", "A1.zz", "a01.33"})));
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        FileName[] fileNames = new FileName[files.length];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = new FileName(files[i]);
        }
        Arrays.sort(fileNames);
        for (int i = 0; i < fileNames.length; i++) {
            answer[i] = fileNames[i].origin;
        }
        return answer;
    }

    static class FileName implements Comparable<FileName> {
        private String origin;
        private String head;
        private int number = -1;

        public FileName(String origin) {
            this.origin = origin;


            for (int i = 0; i < origin.length(); i++) {
                char ch = origin.charAt(i);

                if (Objects.isNull(head)) {
                    if (Character.isDigit(ch)) {
                        head = origin.substring(0, i).toLowerCase();
                    }
                } else {
                    if (!Character.isDigit(ch)) {
                        number = Integer.parseInt(origin.substring(head.length(), i));
                        break;
                    }
                }
            }
            if (number == -1) {
                number = Integer.parseInt(origin.substring(head.length()));
            }
        }

        @Override
        public String toString() {
            return origin;
        }

        @Override
        public int compareTo(FileName o2) {
            if (this.head.equals(o2.head)) {
                if (this.number == o2.number) {
                    return 1;
                }
                return Integer.compare(this.number, o2.number);
            }
            return this.head.compareTo(o2.head);
        }
    }
}
