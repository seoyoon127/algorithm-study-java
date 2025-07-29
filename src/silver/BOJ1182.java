package silver;

import java.util.Scanner;

public class BOJ1182 {
    static int N;
    static int S;
    static int[] nums;
    static int sum;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        nums = new int[N];
        for (int i=0; i<N; i++) nums[i] = sc.nextInt();

        dfs(0,0);
        if (S == 0) cnt -= 1;

        System.out.println(cnt);
    }
    static void dfs(int depth, int sum){
        if(depth == N){
            if (sum == S) cnt+=1;
            return;
        }

        dfs(depth+1, sum + nums[depth]);
        dfs(depth+1, sum);
    }

}