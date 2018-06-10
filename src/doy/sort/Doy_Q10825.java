package doy.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Doy_Q10825 {
    // 도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이 때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.
    //  1. 국어 점수가 감소하는 순서로
    //  2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
    //  3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
    //  4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
    // 첫째 줄에 도현이네 반의 학생의 수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 한 줄에 하나씩 각 학생의 이름, 국어, 영어, 수학 점수가 공백으로 구분해 주어진다. 점수는 1보다 크거나 같고, 100보다 작거나 같은 자연수이다. 이름은 알파벳 대소문자로 이루어진 문자열이고, 길이는 10자리를 넘지 않는다.
    // 문제에 나와있는 정렬 기준으로 정렬한 후 첫째 줄부터 N개의 줄에 걸쳐 각 학생의 이름을 출력한다.
    static class Student implements Comparable<Student> {
        String name;
        int koreanScore;
        int englishScore;
        int mathScore;

        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        @Override
        public int compareTo(Student s) {
            if (this.koreanScore < s.koreanScore) {
                return 1;
            } else if (this.koreanScore == s.koreanScore) {
                if (this.englishScore > s.englishScore) {
                    return 1;
                } else if (this.englishScore == s.englishScore) {
                    if (this.mathScore < s.mathScore) {
                        return 1;
                    } else if (this.mathScore == s.mathScore) {
                        if (this.name.compareTo(s.name) > 0) {
                            return 1;
                        }
                    }
                }
            }
            return -1;
        }
    }

    static Scanner s = new Scanner(System.in);
    public static void run() {
        int t = s.nextInt();
        List<Student> studentList = new ArrayList<>();

        for(int i=0; i<t; i++) {
            Student student = new Student(s.next(), s.nextInt(), s.nextInt(), s.nextInt());
            studentList.add(student);
        }

        Collections.sort(studentList);

        for(int i=0; i<t; i++) {
            String name = studentList.get(i).name;
            System.out.println(name);
        }
    }
}

/*
    풀이가 거의 동일하네요. compareTo()에서 조건문을 좀 더 간결하게 짜는 방법이 없을지 같이 생각해보면 좋을 거 같아요. :)
*/
