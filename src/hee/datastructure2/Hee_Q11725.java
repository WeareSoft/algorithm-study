package hee.datastructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hee_Q11725 {
    static Scanner scanner = new Scanner(System.in);

    private static void bfs(int start, ArrayList<ArrayList<Integer>> list, int[] parents, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); // 시작 정점을 큐에 넣는다.
        parents[start] = 1; // 시작 정점을 방문했다는 정보를 저장한다.

        // 큐에 정점이 없어질 때까지 반복한다.
        while(!queue.isEmpty()) {
            int parent = queue.poll();

            for(int item : list.get(parent)) {
                if(parents[item] == 0) {
                    parents[item] = parent;
                    queue.offer(item);
                }
            }
        }
    }

    public static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 인접 리스트
        ArrayList< ArrayList<Integer> > list = new ArrayList<>();
        int[] parents = new int[N+1];

        // 각 정점의 간선으로 연결되어있는 정점들에 대한 정보를 담을 리스트를 초기화
        for(int i=0; i<=N+1; i++) {
            list.add(new ArrayList<Integer>());
        }

        // 연결 설정
        int a, b;
        for(int i=1; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            // 방향성이 없는 그래프이기 때문에 연결되는 양쪽에 서로에 대한 정보를 넣어준다.
            list.get(a).add(b);
            list.get(b).add(a);
        }

        // bfs
        int start = 1;
        bfs(start, list, parents, N);

        // 결과 출력
        for(int i=2; i<parents.length; i++)
            System.out.println(parents[i]);
    }
}
