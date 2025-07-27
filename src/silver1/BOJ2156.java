package silver1;

import java.util.Scanner;

public class BOJ2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[N];

        if (N == 1) {
            System.out.println(arr[0]);
            return;
        } else if (N == 2) {
            System.out.println(arr[0] + arr[1]);
            return;
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(dp[1], Math.max(arr[0], arr[1]) + arr[2]);


        for (int n=3; n<N; n++){
            dp[n] =  Math.max(dp[n-3] + arr[n-1] + arr[n] , Math.max(dp[n-2] + arr[n], dp[n-1]));
        }

        System.out.println(dp[N-1]);
    }
}
