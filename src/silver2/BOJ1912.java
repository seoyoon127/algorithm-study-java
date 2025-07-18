package silver2;

import java.util.Scanner;

public class BOJ1912 {
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N+1];
        dp = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i];
        }

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i], dp[i-1] + dp[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
