package gold5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ2565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] electric = new int[N][2];

        for (int i=0; i<N; i++){
            electric[i][0] = sc.nextInt();
            electric[i][1] = sc.nextInt();
        }
        Arrays.sort(electric, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int[] dp = new int[N];
        int max = 0;
        for (int i=0; i<N; i++){
            dp[i] = 1;
            for (int j=0; j<i; j++){
                if (electric[j][1] < electric[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(N-max);
    }
}