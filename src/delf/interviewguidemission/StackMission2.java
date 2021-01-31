package interviewguidemission;

import java.util.*;

public class StackMission2 {
    public static void main(String[] args) {
//        System.out.println(new StackMission2().solution("{{{}}"));
//        System.out.println(new StackMission2().solution("{{{{}}"));
//        System.out.println(new StackMission2().solution("}}}}{}}}"));
//        System.out.println(new StackMission2().solution("{{{{"));
        EnumSet<Fruit> fruits = EnumSet.allOf(Fruit.class);
        System.out.println(String.valueOf(fruits));
        EnumMap<Fruit, String> map = new EnumMap<>(Fruit.class);
        map.put(Fruit.APPLE, "apple");
        map.put(Fruit.APPLE, "banana");

        System.out.println(map);
    }

    enum Fruit {
        APPLE("testinput");
        String tmp;

        Fruit(String tmp) {
            this.tmp = tmp;
        }
    }

    /*
     * 문제 2. 괄호 몇개를 뒤집어야 정상적인 수식을 만들 수 있는지 계산하는 코드를 작성하라.
     * 예) {{{}} => exception
     * 예) {{{{}} => 1
     * 예) }}}}{}}} => 3
     * 예) {{{{ => 2
     * */
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (ch == '}') {
                    cnt++;
                    stack.push('{');
                } else {
                    stack.push(ch);
                }
                continue;
            }

            if (ch == '{') {
                stack.push(ch);
            } else if (ch == '}' && stack.peek() == '{') {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return cnt;
        }

        if (stack.size() % 2 != 0) {
            return -1;
        }

        return cnt + stack.size() / 2;
    }
}
