package hee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Hee_Q1850 {
//    static Scanner scanner = new Scanner(System.in);
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));


    public static long gcd(long num1, long num2){
        if(num2 == 0){
            return num1;
        }
        else{
            return gcd(num2, num1 % num2);
        }
    }
    public static void run() throws Exception{
//        int count1 = scanner.nextInt();
//        int count2 = scanner.nextInt();

        Long[] counts = new Long[2];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int i=0;
        while (stringTokenizer.hasMoreTokens()){
            counts[i] = Long.parseLong(stringTokenizer.nextToken());
            i++;
        }
        long gcdOfCount = gcd(counts[0], counts[1]);

        for(int j=0; j<gcdOfCount; j++){
            bufferedWriter.write("1");
//            System.out.print("1");
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}


/*
    풀이가 같네요 :)
    저번에도 말했듯이 자료형 공부와 정리가 필요한 것 같습니당 ㅎㅎ
*/
