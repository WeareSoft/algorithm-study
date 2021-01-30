package programmers.skillcheck;

import java.util.*;

public class SkillCheck0101 {
    public static void main(String[] args) {
        System.out.println(new SkillCheck0101().solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
    }


    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String name : completion) {
            map.merge(name, 1, Integer::sum);
        }
        for (String name : participant) {
            Integer n = map.get(name);
            if (Objects.isNull(n) || n == 0) {
                return name;
            }
            map.put(name, n - 1);
        }
        throw new IllegalArgumentException();
    }
}
