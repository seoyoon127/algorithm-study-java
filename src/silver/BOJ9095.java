package silver;

import java.util.Scanner;

public class BOJ9095 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];    // 크기 T인 배열 선언
        for (int i = 0; i < T; i++) {
            arr[i] = sc.nextInt(); // 정수 하나씩 배열에 저장
        }

        for(int a: arr) {
            dp = new int[a + 1];
            dp[1] = 0;
            System.out.println(recur(a));
        }
    }

    static int recur(int N){

        if (N == 0) return 1;
        if (N < 0) return 0;

        dp[N] = recur(N - 1) + recur(N - 2) + recur(N - 3);

        return dp[N];
    }
}
