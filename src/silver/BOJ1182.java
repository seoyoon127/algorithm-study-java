package silver;

import java.util.Arrays;
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

        for (int i=1; i<=N; i++){
            sum = 0;
            combination(0, 0, i);
        }

        System.out.println(cnt);
    }
    static void combination(int idx, int selected, int r){
        if (selected == r){
            if (sum == S)  cnt += 1;
            return;
        }
        for (int i= idx; i<N; ++i){
            sum += nums[i];
            combination(i+1, selected+1, r);
            sum -= nums[i];
        }
    }
}