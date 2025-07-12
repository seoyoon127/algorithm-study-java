package silver;

import java.util.Scanner;

public class BOJ2193 {
    static long dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new long[N+1];

        System.out.println(recur(N));
    }

    static long recur(int N){
        if (N < 1) return 0;
        if (N == 1)
            dp[N] = 1;
        else if (dp[N] == 0){
            dp[N] = recur(N-1) + recur(N-2);
        }
        return dp[N];
    }
}
