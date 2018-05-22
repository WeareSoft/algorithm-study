package doy;

import java.io.*;
import java.util.*;

public class Doy_Q11004 {
    // 수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
    /*
    1. Scanner, Arrays.sort() : 478692 KB / 2072 MS
    2. BufferedReader, Arrays.sort() : 220312 KB / 5068 MS
    3. Scanner, Collections.sort() : 시간 초과
    4. BufferedReader, Collections.sort() : 564748 KB / 4896 MS
    */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void run() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] numArray = new int [count];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<count; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArray);
        bw.write(Integer.toString(numArray[K-1]));

        br.close();
        bw.close();
    }
}
