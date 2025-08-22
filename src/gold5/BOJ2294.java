package gold5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2294 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n];
        for (int i=0; i<n; i++){
            coin[i] = sc.nextInt();
        }
        Arrays.sort(coin);
        dp = new int[k+1];

        int cnt = 0;
        for (int i=0; i<k; i++){
            for (int j=0; j<n; j++){
                if (i+coin[j] <= k){
                    if (dp[i+coin[j]] > 0 && dp[i] > 0)
                        dp[i+coin[j]] = Math.min(dp[i+coin[j]], dp[i] + 1);
                    else if(i==0 || dp[i] > 0)
                        dp[i+coin[j]] =dp[i] + 1;
                }
            }
        }
        System.out.println(dp[k] == 0 ? -1 : dp[k]);
    }
}
