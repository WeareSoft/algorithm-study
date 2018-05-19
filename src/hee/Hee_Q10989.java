package hee;

import java.io.*;

public class Hee_Q10989 {
    // N개의 수(이 수는 10,000보다 작거나 같은 자연수)가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
    // 시간초과 오류 -> 개수가 10,000,000개를 5초안에 정렬해야 하기 때문에
    // 1. Scanner 사용 X: BufferedReader, BufferedWriter 등으로 입출력 속도를 개선
    // 2. Sort 사용 X: 배열을 이용한 counting sort 방법
    // [방법1] http://zoonvivor.tistory.com/43
    // [방법2] http://lifeignite.tistory.com/34

    public static void run() throws IOException {

        /* [방법1] 481780 KB 1688 MS */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] num_arrarys = new int[10001]; // 10,000보다 작거나 같은 자연수의 크기만큼의 배열

        // 들어오는 수에 해당하는 index의 배열값을 증가
        for (int i=0; i<count; i++) {
            num_arrarys[Integer.parseInt(br.readLine())]++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // index: 0~10,000까지 반복하면서 해당 index를 배열값만큼 출력
        for (int i=0; i<10001; i++) {
            // num_arrarys[i]가 0보다 작거나 같으면 해당 index의 값이 들어오지 않은 것이기 때문에 패스
            if (num_arrarys[i] > 0) {
                for (int j=0; j<num_arrarys[i]; j++) {
                    bw.write(Integer.toString(i) + "\n");
                    // bw.flush(); 사용 안하면 이클립스 Console에 출력이 안될 수 있음
                    // bw.flush();를 사용하면 시간초과가 뜨기 때문에 여기서는 사용 X
                }
            }
        }
        br.close();
        bw.close();


        /* [방법2] 460768 KB, 1848 MS */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder(); // 방법2와 다른 부분
//
//        int count = Integer.parseInt(br.readLine());
//        int[] num_arrarys = new int[10001];
//
//        for (int i=0; i<count; i++){
//            num_arrarys[Integer.parseInt(br.readLine())]++;
//        }
//
//        for(int i =0; i<10001; i++){
//            // num_arrarys[i]가 0이 아니면 해당 index의 값이 적어도 하나는 들어온 것
//            while(num_arrarys[i] != 0){
//                sb.append("" + i + "\n");
//                num_arrarys[i]--; // 해당 index에 배열값을 하나씩 감소
//            }
//        }
//        // string간의 +연산을 사용하면 시간초과
//        System.out.println(sb.toString()); // 한꺼번에 모아서 출력



        /* Scanenr 사용 -> 시간 초과*/
//        int count = scanner.nextInt();
//        ArrayList<Integer> arrayLists = new ArrayList<>();
//
//        for(int i=0; i<count; i++){
//            int num = scanner.nextInt();
//            arrayLists.add(num);
//        }
//
//        Collections.sort(arrayLists);
//        for (int j=0; j<count; j++) {
//            System.out.println(arrayLists.get(j));
//        }

    }
}
