package hee.datastructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Hee_Q4195 {
//    static Scanner scanner = new Scanner(System.in); // 컴파일 에러
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] root, nodeCount;

    static int find(int x) {
        if (x == root[x]) {
            return x;
        } else {
            return root[x] = find(root[x]); // 경로 압축
        }
    }

    static int union(int x, int y){
        x = find(x);
        y = find(y);

        // 두 값을 root가 같지 않으면
        if(x != y) {
            root[y] = x; // y의 root를 x로 변경
            nodeCount[x] += nodeCount[y]; // x의 node 수에 y의 node 수를 더한다.
            nodeCount[y] = 1; // x에 붙은 y의 node 수는 1로 초기화
        }
        return nodeCount[x]; // 가장 root의 node 수 반환
    }

    public static void run() throws IOException {
        int n = Integer.parseInt(br.readLine());

        while (n > 0){
            int f = Integer.parseInt(br.readLine());
            int F = 2 * f; // f줄 * 2개의 이름 = 최대 2f개의 이름

            // root[i] = i, nodeCount[i] = 1 초기화
            root = new int[F];
            nodeCount = new int[F];
            for (int i=0; i<F; i++){
                root[i] = i;
                nodeCount[i] = 1;
            }

            // 입력받은 이름: Key, 임의의 cnt를 계속해서 +1 : Value
            HashMap<String, Integer> friendNetwork = new HashMap<>();
            int cnt = 0;

            while (f > 0){
                String name[] = br.readLine().split(" ");

                if(!friendNetwork.containsKey(name[0])){
                    friendNetwork.put(name[0], cnt++);
                }
                if(!friendNetwork.containsKey(name[1])){
                    friendNetwork.put(name[1], cnt++);
                }

                System.out.println(union(friendNetwork.get(name[0]), friendNetwork.get(name[1])));
                f--;
            }

            n--;
        }
    }

//    static void printHashMap(HashMap hashMap) {
//        Iterator<String> iterator = hashMap.keySet().iterator();
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            System.out.print("key="+key);
//            System.out.println(" value="+hashMap.get(key));
//        }
//    }
}

// references: http://joonas-yoon.blogspot.com/2016/04/4195.html