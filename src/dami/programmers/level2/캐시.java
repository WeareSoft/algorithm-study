package dami.programmers.level2;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/17680
public class 캐시 {
	public int solution(int cacheSize, String[] cities) {
		if (cacheSize == 0) {
			return cities.length * 5;
		}

		int time = 0;
		Queue<String> cache = new LinkedList<>();
		for (String city : cities) {
			city = city.toLowerCase();

			if (cache.contains(city)) {
				time++;
				cache.remove(city);
			} else {
				time += 5;
			}

			if (cache.size() == cacheSize) {
				cache.poll();
			}
			cache.offer(city);
		}

		return time;
	}
}

/*  // 다른 풀이 1
	// LRU 알고리즘 효율을 위해 Map 사용

class Solution {
  public int solution(int cacheSize, String[] cities) {
      int answer = 0;
        LRU<String, String> clsTemp = LRU.newInstance(cacheSize);
        for (int i = 0; i < cities.length; i++) {
            String sTemp = cities[i].toUpperCase();
            if(clsTemp.containsKey(sTemp)) {
                answer++;
            }else {
                answer +=5;
            }
            clsTemp.put(sTemp, sTemp);
        }

        return answer;
    }
}

class LRU<K, V> extends LinkedHashMap<K, V> {
    private int size;

    private LRU(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }
    public static <K,V> LRU<K,V> newInstance(int size) {
        return new LRU<K,V>(size);
    }
}

*/


/*  // 다른 풀이 2
	// removeFirstOccurrence(Object o) == remove(Object o)
	// => 값 제거 성공하면 true / 실패하면 false 반환하는 것 이용해서 cache hit 여부 확인한 풀이
	// 참고로 removeLastOccurrence()도 있음
class Solution {
  public int solution(int cacheSize, String[] cities) {
        int time = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            boolean hit = ((LinkedList<String>) queue).removeFirstOccurrence(cities[i].toUpperCase());
            queue.add(cities[i].toUpperCase());
            time += 1;
            if (!hit) {
                time += 4;
                if (queue.size() > cacheSize) {
                    String removed = ((LinkedList<String>) queue).removeFirst();
                }
            }
        }

        int answer = time;
        return answer;
    }
}

*/
