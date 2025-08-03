package silver1;

import java.util.Scanner;

public class BOJ9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0; i<T; i++){
            int N = sc.nextInt();
            int[][] arr = new int[2][N];
            int[][] dp = new int[2][N];
            for (int j=0; j<2; j++){
                for (int k=0; k<N; k++){
                    arr[j][k] = sc.nextInt();
                }
            }

            if (N == 1){
                System.out.println(Math.max(arr[0][0], arr[1][0]));
                continue;
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = dp[1][0] + arr[0][1];
            dp[1][1] = dp[0][0] + arr[1][1];

            for (int l=2; l<N; l++){
                dp[0][l] = Math.max(dp[1][l-1], dp[1][l-2]) + arr[0][l];
                dp[1][l] = Math.max(dp[0][l-1], dp[0][l-2]) + arr[1][l];
            }

            System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
        }
    }
}
