package hee.boj.datastructure2;

import java.io.*;
import java.util.StringTokenizer;

public class Hee_Q11723 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void run() throws IOException {
        int S = 0; // 비어있는 공집합

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            int num;

            switch (operator) {
                case "add": // S|(1<<i)
                    num = Integer.parseInt(st.nextToken());
                    if ((S & (1 << num)) == 0)
                        S = S | (1 << num);
                    break;
                case "remove": // S&~(1<<i)
                    num = Integer.parseInt(st.nextToken());
                    if ((S & (1 << num)) != 0)
                        S = S & ~(1 << num);
                    break;
                case "check": // S&(1<<i): i가 없으면 return 0
                    num = Integer.parseInt(st.nextToken());
                    System.out.print(num + ": ");
                    if ((S & (1 << num)) == 0)
                        bw.write("0\n");
                    else
                        bw.write("1\n");
                    break;
                case "toggle": // S^(1<<i)
                    num = Integer.parseInt(st.nextToken());
                    S = S ^ (1 << num);
                    break;
                case "all":  // (1<<N)–1
                    S = ((1 << 21) - 1);
                    break;
                case "empty": // 0
                    S = 0;
                    break;
            }
        }
        bw.flush();
        bw.close();
    }


}
