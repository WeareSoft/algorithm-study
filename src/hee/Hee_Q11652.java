package hee;

import java.util.*;


public class Hee_Q11652 {
    // 준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -262보다 크거나 같고, 262보다 작거나 같다.
    // 준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 만약, 가장 많이 가지고 있는 정수가 여러가지라면, 작은 것을 출력한다.
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int count = scanner.nextInt();
        ArrayList<Long> arrayLists = new ArrayList<>();
        LinkedHashMap<Long , Integer> hashMaps = new LinkedHashMap<>();

        for (int i=0; i<count; i++){
            arrayLists.add(scanner.nextLong());
        }
        Collections.sort(arrayLists);

        for (int i=0; i<count; i++){
            long key = arrayLists.get(i);

            //해당하는 값이 hashmap에 있으면 count 증가
            if(hashMaps.containsKey(key)){
                hashMaps.put(key, hashMaps.get(key) + 1);
            }
            //해당하는 값이 hashmap에 없으면 count=1 (처음 들어오는 값)
            else{
                hashMaps.put(key, 1);
            }
        }

        // 가장 큰 값의 value를 가진 key를 가져온다.
        // (가장 큰 값의 value가 여러 개면, key값 중 가장 작은 것)
        int maxValue=(Collections.max(hashMaps.values()));

        for (Map.Entry<Long, Integer> entry : hashMaps.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.println(entry.getKey());
                return;
            }
        }
    }
}

/*
    map의 key정렬을 찾아보니 기본으로 key 오름차순 정렬을 지원하는 TreeMap이라는 것이 있네요 :)
    HashMap, LinkedHashMap, TreeMap.. 등 map 특징도 정리해보면 좋을 거 같아요~ㅎㅎㅎ
*/
