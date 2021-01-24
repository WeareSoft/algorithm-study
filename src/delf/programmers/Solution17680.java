package programmers;

import java.util.*;

/**
 * 캐시
 * https://programmers.co.kr/learn/courses/30/lessons/17680
 */
public class Solution17680 {
    public static void main(String[] args) {
        System.out.println(new Solution17680().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));//,50
//        System.out.println(new Solution17680().solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));//,21
//        System.out.println(new Solution17680().solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));//,60
//        System.out.println(new Solution17680().solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));//,52
//        System.out.println(new Solution17680().solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));//,16
        System.out.println(new Solution17680().solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));//,25

//        System.out.println(new Solution17680().solution(2, new String[]{"Jeju", "Jeju", "Jeju", "Jeju", "Jeju"}));//,25
    }

    private final static int HIT = 1;
    private final static int MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();

        int time = 0;
        for (String cityOrigin : cities) {
            String city = cityOrigin.toLowerCase();
            System.out.println(city + " " + q);
            if (q.contains(city)) {
                time += HIT;
                q.remove(city);
            } else {
                time += MISS;
                if (q.size() >= cacheSize) {
                    q.poll();
                }
            }
            if (q.size() < cacheSize) {
                q.add(city);
            }
        }
        return time;
    }

    class QueueSet<T> {
        private Queue<T> queue;
        private T lastData;
        private int maxsize;

        public boolean add(T element) {
            if (queue.isEmpty()) {
                lastData = element;
            }
            return queue.add(element);
        }
    }
}
