package gold5;

import java.util.Scanner;

public class BOJ2225 {
    static int N;
    static int K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        double[][] dp = new double[K+1][N+1];
        for (int i=0; i<=N; i++){
            dp[1][i] = 1;
        }
        for (int i=2; i<=K; i++){
            for (int j=0; j<=N; j++){
                for (int k=0; k<=j; k++){
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] = dp[i][j] % 1000000000;
            }
        }
        System.out.println((int) dp[K][N]);
    }
}
