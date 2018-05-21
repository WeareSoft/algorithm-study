package hee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Hee_Q10814 {
    // 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이 때, 회원들을 나이가 증가하는 순으로,
    // 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
    // Reference
    // http://wjheo.tistory.com/entry/Java-%EC%A0%95%EB%A0%AC%EB%B0%A9%EB%B2%95-Collectionssort
    public static class Person implements Comparable<Person>{
        int age;
        String name;

        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }

        public int getAge(){
            return this.age;
        }

        public String getName(){
            return this.name;
        }

       @Override
       public int compareTo(Person person) {
           if (this.age > person.age){
               return 1;
           } else if (this.age < person.age){
               return -1;
           } else {
               return 0;
           }
       }
   }

    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int count = scanner.nextInt();
        ArrayList<Person> arrayLists = new ArrayList<>();

        for(int i=0; i<count; i++){
            int age = scanner.nextInt();
            String name = scanner.nextLine();

            arrayLists.add(new Person(age, name));
        }

        Collections.sort(arrayLists);

        for(int i=0; i<count; i++){
            System.out.println(arrayLists.get(i).getAge() + "" + arrayLists.get(i).getName());
        }

    }
}

/*
가입순서대로 입력이 주어진다면 가입순서는 고려하지 않아도 된다는걸 알아가요 :)
*/
