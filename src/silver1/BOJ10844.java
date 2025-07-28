package silver1;

import java.util.*;

public class BOJ10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        final int MOD = 1_000_000_000;

        long[][] dp = new long[N+1][10];
        for (int i=1; i<=9; i++){
             dp[1][i] = 1;
        }

        for (int i=2; i<=N; i++){
            for (int j=0; j<=9; j++){
                long jCnt = dp[i-1][j];
                if (j > 0) dp[i][j-1] = (dp[i][j-1] + jCnt) % MOD;
                if (j < 9) dp[i][j+1] = (dp[i][j+1] + jCnt) % MOD;
            }
        }

        long sum = 0;
        for (int i=0; i<=9; i++){
            sum = (sum + dp[N][i]) % MOD;
        }
        System.out.println(sum % MOD);
    }
}
