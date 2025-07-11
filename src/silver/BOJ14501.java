package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ14501 {
    static int N;
    static int [][] arr;
    static int [] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1][2];
        dp = new int[N+1];
        Arrays.fill(dp, -1);
        sc.nextLine();
        for (int i=1; i<=N; i++){
            String input = sc.nextLine();
            arr[i][0] = Integer.parseInt(input.split(" ")[0]);
            arr[i][1] = Integer.parseInt(input.split(" ")[1]);
        }
        int ans = 0;
        for (int i=1; i<=N; i++) {
            if (arr[i][0] <= arr.length - i + 1)
                ans = Math.max(ans, maxProfit(i));
        }
        System.out.println(ans);
    }
    static int maxProfit(int start) {
        if (start > N) return 0;
        if (dp[start] != -1) return dp[start];

        int time = arr[start][0];
        int pay = arr[start][1];

        // 1. 상담을 하는 경우
        int doIt = 0;
        if (start + time - 1 <= N) {
            doIt = pay + maxProfit(start + time);
        }

        // 2. 상담을 하지 않는 경우
        int skipIt = maxProfit(start + 1);

        dp[start] = Math.max(doIt, skipIt);
        return dp[start];
    }

}
