package silver;

import java.util.Scanner;

public class BOJ11727 {
    static int dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[n+1];
        dp[0] = dp[1] = 1;

        System.out.println(recur(n));
    }

    static int recur(int n){
        if (dp[n] == 0){
            dp[n] = (recur(n-1) + 2 * recur(n-2)) % 10007;
        }
        return dp[n];
    }
}
