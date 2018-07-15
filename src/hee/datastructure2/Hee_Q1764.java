package hee.datastructure2;

import java.util.*;

public class Hee_Q1764 {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        HashSet<String> hashSet1 = new HashSet();
        HashSet<String> hashSet2 = new HashSet();

        while (N-- > 0) {
            hashSet1.add(scanner.next());
        }
        while (M-- > 0) {
            hashSet2.add(scanner.next());
        }

        hashSet1.retainAll(hashSet2); // Set의 교집합

        /* TreeSet이면 정렬과정이 없어도 된다. */
        String res[] = hashSet1.toArray(new String[hashSet1.size()]);
        Arrays.sort(res); // 오름차순 정렬

        System.out.println(res.length);
        for (int i = 0; i <= res.length - 1; i++) {
            System.out.println(res[i]);
        }
    }

}
