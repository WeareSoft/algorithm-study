package programmers;

import java.util.Objects;

/**
 * [3차] 파일명 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/17686
 */
public class Solution17686 {
    public static void main(String[] args) {
        System.out.println(new FileName("foo9.txt"));
        System.out.println(new FileName("foo010bar020.zip"));
        System.out.println(new FileName("F-15"));
        System.out.println(new FileName("0123"));
    }

    static class FileName {
        private String origin;
        private String head;
        private String number;
        private String tail;

        public FileName(String origin) {
            this.origin = origin;
            for (int i = 0; i < origin.length(); i++) {
                char ch = origin.charAt(i);

                if (Objects.isNull(head)) {
                    if (Character.isDigit(ch)) {
                        head = origin.substring(0, i);
                    }
                } else {
                    if (!Character.isDigit(ch)) {
                        number = origin.substring(head.length(), i);
                        tail = origin.substring(i);
                        break;
                    }
                }
            }
        }

        @Override
        public String toString() {
            return "FileName{" +
                    "origin='" + origin + '\'' +
                    ", head='" + head + '\'' +
                    ", number='" + number + '\'' +
                    ", tail='" + tail + '\'' +
                    '}';
        }
    }
}
