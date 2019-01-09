package hee.boj.math2_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// n항까지의 피보나치수열의 합을 S(n)이라하면, S(n) = a(n+2) - 1이다.
// n=1 일 때, S(n) = a(n) = 1 => a(n+2)-1= 1 이므로 성립.
// n=k일 때 성립한다고 하면, S(k) = a(k+2) - 1 = a(k) + a(k+1) - 1
// 양변에 a(k+1)을 더하면 S(k) + a(k+1) = a(k+2) + a(k+1) - 1 => S(k+1) = a(k+3) - 1
// 자연수 n에 대해 식이 성립한다.
// 구하고자 하는 값은 S(b) - S(a-1) = f(b+2) - f(a+1) 이다.
public class Hee_Q2086 {
    static Map<Long, Long> map = new HashMap<>();
    static final long MOD = 1000000000;

    public static void run(){
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        long t = fib(b+2) - fib(a+1);
        t = (t + MOD) % MOD;
        System.out.println(t);
    }

    /*
    F(2n) = F(n)[2*F(n+1) – F(n)]
    F(2n + 1) = F(n)**2 + F(n+1)**2
     */
    static long fib(long n){
        if (map.containsKey(n)) return map.get(n);
        if (n < 3) return 1;

        long k = n / 2;
        long a = fib(k), b = fib(k+1), r;

        // %m 을 듬뿍 바른다.
        if (n % 2 == 0) {
            // 0 <= a, b < 10**9 이므로
            // -10**9 < 2*b -a < 2*19**9. 이것은 java int 타입의 범위를 넘지 않는다.
            r = (a  * ((2 * b) - a + MOD)) % MOD;
        } else {
            // a*a + b*b는 java long 타입의 범위를 넘지 않는다.
            r = (a*a + b*b) % MOD;
        }

        map.put(n, r);
        return r;
    }
}
