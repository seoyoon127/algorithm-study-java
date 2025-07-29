package silver1;

import java.util.Scanner;

public class BOJ14888 {
    static int N;
    static int[] nums;
    static int[] op = new int[4]; // + - * /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];

        for (int i = 0; i < N; i++) nums[i] = sc.nextInt();
        for (int i = 0; i < 4; i++) op[i] = sc.nextInt(); // + - * /

        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void dfs(int idx, int sum){
        if (idx == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                if (i == 0) dfs(idx + 1, sum + nums[idx]);
                else if (i == 1) dfs(idx + 1, sum - nums[idx]);
                else if (i == 2) dfs(idx + 1, sum * nums[idx]);
                else if (i == 3) dfs(idx + 1, sum / nums[idx]);

                op[i]++;
            }
        }
    }
}
