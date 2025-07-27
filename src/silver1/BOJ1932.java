package silver1;

import java.util.Scanner;

public class BOJ1932 {
    static int[][] dp;
    static int[][] arr;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N][N];
        for(int i=0; i<N; i++){
            for (int j=0; j<=i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp = new int[N][N];
        System.out.println(recur(0,0));

    }
    static int recur(int n, int i){
        if (n > N-1) return 0;
        if (dp[n][i] == 0){
            dp[n][i] = Math.max(recur(n+1, i), recur(n+1, i+1)) + arr[n][i];
        }
        return dp[n][i];
    }
}
