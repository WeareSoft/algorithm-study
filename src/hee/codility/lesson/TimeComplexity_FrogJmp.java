package hee.codility.lesson;

public class TimeComplexity_FrogJmp {
    public int solution(int X, int Y, int D) {
        int c = Y - X;
        if (c == 0) {
            return 0;
        }

        int i = c / D;
        if (c % D != 0) { // 나머지가 있으면
            i++;
        }
        return i;
    }
}
