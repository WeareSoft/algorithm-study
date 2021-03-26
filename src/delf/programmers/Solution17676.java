package programmers;

/**
 * 추석 트래픽
 * https://programmers.co.kr/learn/courses/30/lessons/17676
 */
public class Solution17676 {
    public int solution(String[] lines) {
        int answer = 0;
        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];

        getTimes(lines, startTimes, endTimes);

        for (int i = 0; i < lines.length; i++) {
            int cnt = 0;
            int startOfSection = startTimes[i];
            int endOfSection = startOfSection + 1000;

            answer = getAnswer(lines, answer, startTimes, endTimes, cnt, startOfSection, endOfSection);

            cnt = 0;
            startOfSection = endTimes[i];
            endOfSection = startOfSection + 1000;

            answer = getAnswer(lines, answer, startTimes, endTimes, cnt, startOfSection, endOfSection);
        }

        return answer;
    }

    private int getAnswer(String[] lines, int answer, int[] startTimes, int[] endTimes, int cnt, int startOfSection, int endOfSection) {
        for (int j = 0; j < lines.length; ++j) {
            if (startTimes[j] >= startOfSection && startTimes[j] < endOfSection) {
                cnt++;
            } else if (endTimes[j] >= startOfSection && endTimes[j] < endOfSection) {
                cnt++;
            } else if (startTimes[j] <= startOfSection && endTimes[j] >= endOfSection) {
                cnt++;
            }
        }

        answer = Math.max(cnt, answer);
        return answer;
    }

    private void getTimes(String[] lines, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < lines.length; i++) {
            String[] log = lines[i].split(" ");
            String[] responseTime = log[1].split(":");
            int processingTime = (int) (Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
            int startTime = 0;
            int endTime = 0;

            endTime += Integer.parseInt(responseTime[0]) * 60 * 60 * 1000;
            endTime += Integer.parseInt(responseTime[1]) * 60 * 1000;
            endTime += (int) (Double.parseDouble(responseTime[2]) * 1000);
            startTime = endTime - processingTime + 1;

            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }
    }
}
