package hee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hee_Q10825 {
    // 도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이 때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.
    // 국어 점수가 *감소하는 순서로
    // 국어 점수가 같으면 영어 점수가 *증가하는 순서로
    // 국어 점수와 영어 점수가 같으면 수학 점수가 *감소하는 순서로
    // 모든 점수가 같으면 이름이 사전 순으로 *증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)

    static Scanner scanner = new Scanner(System.in);

    static class Student implements Comparable<Student> {
        String name;
        int korean_score;
        int english_score;
        int math_score;

        public Student(String name, int korean_score, int english_score, int math_score) {
            this.name = name;
            this.korean_score = korean_score;
            this.english_score = english_score;
            this.math_score = math_score;
        }

        // 국어 감소 > 영어 증가 > 수학 감소 > 이름 사전순
        @Override
        public int compareTo(Student student) {
            // 국어 감소
            if(this.korean_score < student.korean_score) {
                return 1;
            } else if(this.korean_score == student.korean_score) {
                // 영어 증가
                if(this.english_score > student.english_score) {
                    return 1;
                } else if(this.english_score == student.english_score) {
                    // 수학 감소
                    if(this.math_score < student.math_score) {
                        return 1;
                    } else if(this.math_score == student.math_score) {
                        if(this.name.compareTo(student.name) > 0){
                            return 1;
                        }else{
                            return -1;
                        }
                    }
                    return -1;
                }
                return -1;
            }
            return -1;
        }
    }

    public static void run() {
        int count = scanner.nextInt();
        ArrayList<Student> arrayLists = new ArrayList<>();

        for(int i=0; i<count; i++){
            String name = scanner.next();
            int korean_score = scanner.nextInt();
            int english_score = scanner.nextInt();
            int math_score = scanner.nextInt();

            arrayLists.add(new Student(name, korean_score, english_score, math_score));
        }

        Collections.sort(arrayLists);
        for (int j=0; j<count; j++) {
            System.out.println(arrayLists.get(j).name);
        }
    }
}


