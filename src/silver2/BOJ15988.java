package silver2;

import java.util.Scanner;

public class BOJ15988 {
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int max = 0;
        for (int i=0; i<N; i++){
            int x = sc.nextInt();
            arr[i] = x;
            max = Math.max(max, x);
        }
        dp = new long[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i=0; i<N; i++){
            System.out.println(recur(arr[i]));
        }
    }
    static long recur(int n){
        if (dp[n] == 0){
            dp[n] = recur(n-1) + recur(n-2) + recur(n-3);
        }
        return dp[n] % 1000000009;
    }
}
