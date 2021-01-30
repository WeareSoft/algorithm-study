package programmers.skillcheck;

public class SkillCheck0102 {
    public boolean solution(String s) {
        int p = 0;
        int y = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
            }
            if (ch == 'p') {
                p++;
            } else if (ch == 'y') {
                y++;
            }
        }
        return p == y;
    }
}
