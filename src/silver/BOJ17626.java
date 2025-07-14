package silver;

import java.util.Scanner;

public class BOJ17626 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];

        System.out.println(recur(n));
    }
    static int recur(int n){
        if (n == 0) return 0;
        if (dp[n] != 0) return dp[n];
        int min = 4;
        int sq = (int) Math.sqrt(n);
        for (int i = sq; i>0; i--){
            min = Math.min(min, recur(n - i * i)+1);
        }

        return dp[n] = min;
    }
}
