package doy.sort;

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

/*
    입출력 방법과 정렬 방법에 따라 걸리는 시간에 차이가 있다는 것을 알았네요.
    이 내용을 따로 issue로 정리해두면 좋을 거 같아요. 저는 1.번을 사용해서 풀었는데 221424 KB / 5080 MS 이런 결과가 나왔네요.
    정확히 확인해볼 필요가 있는 거 같아요~ :)
    StringTokenizer 사용법도 따로 issue에 추가하면 좋을 거 같아요. 
    확실히..BufferedReader를 이용하면 StringTokenizer로 인해 코드가 좀 복잡해지는 거 같네요.
*/
