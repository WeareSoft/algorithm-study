package hee.datastructure2;

import java.util.*;

public class Hee_Q7785 {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int n = scanner.nextInt();
        TreeSet<String> redBlackTree = new TreeSet<>(); // 순서있음
        HashSet<String> hashTable = new HashSet<>(); // 순서없음

        while (n-- > 0){
            String name = scanner.next();
            String opr = scanner.next();

            if(opr.equals("enter")){
                redBlackTree.add(name);
//                hashTable.add(name);
            } else {
                redBlackTree.remove(name);
//                hashTable.remove(name);
            }
        }

        /* TreeSet 이용 시 내림차순 정렬 */
        Iterator itr = redBlackTree.descendingSet().iterator(); // 내림차순 정렬
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        /* HashSet 이용 시 정렬 */
//        String res[] = hashTable.toArray(new String[hashTable.size()]);
//        Arrays.sort(res); // 오름차순 정렬
//        for (int i=res.length-1; i>=0; i--) { // 내림차순 출력
//            System.out.println(res[i]);
//        }
    }
}

// Set 관련 references: https://onsil-thegreenhouse.github.io/programming/java/2018/02/21/java_tutorial_1-23/