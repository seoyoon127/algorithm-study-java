package silver;

import java.util.Scanner;

public class BOJ1003 {
    public static int cnt0 = 0;
    public static int cnt1 = 0;
    static Integer[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = sc.nextInt();
        }
        for(int a: arr) {
            dp = new Integer[a+1][2];
            for (int i = 0; i <= a; i++) {
                dp[i][0] = 0;
                dp[i][1] = 0;
            }
            fibonacci(a);
            System.out.println(dp[a][0] + " " + dp[a][1]);
        }
    }
    static void fibonacci(int n) {
        if (n == 0) {
            dp[n][0] = 1;
        } else if (n == 1) {
            dp[n][1] = 1;
        } else {
            if (dp[n][0] == 0 && dp[n][1] == 0) {
                fibonacci(n - 1);
                fibonacci(n - 2);
                dp[n][0] = dp[n - 1][0] + dp[n - 2][0];
                dp[n][1] = dp[n - 1][1] + dp[n - 2][1];
            }
        }
    }
}