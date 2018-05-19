package doy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Doy_Q10814 {
    // 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이 때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
    // 첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
    // 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.
    // 첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
    static class People implements Comparable<People> {
        int age;
        String name;
        int join;

        public People(int age, String name, int join) {
            this.age = age;
            this.name = name;
            this.join = join;
        }

        @Override
        public int compareTo(People p) {
            if(this.age > p.age) {
                return 1;
            }
            else if(this.age == p.age) {
                if(this.join > p.join) {
                    return 1;
                }
            }
            return -1;
        }
    }

    static Scanner s = new Scanner(System.in);
    public static void run() {
        int t = s.nextInt();
        List<People> peopleList = new ArrayList<>();

        for(int i=0; i<t; i++) {
            int age = s.nextInt();
            String name = s.next();
            peopleList.add(new People(age, name, i));
        }

        Collections.sort(peopleList);

        for(int i=0; i<t; i++) {
            People p = peopleList.get(i);
            System.out.println(p.age + " " + p.name);
        }
    }
}

/*
    풀이 과정이 거의 동일합니다.
    그런데 java의 ArrayList는 add하는대로 순서가 보장기 때문에 먼저 가입한 사람에 대한 설정으로 join을 넣지 않아도 될 거 같아요 :)
    if(this.join > p.join) 부분을 제거해서 비교횟수를 조금 줄일 수 있습니다.
*/
