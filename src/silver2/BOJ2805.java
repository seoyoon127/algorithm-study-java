package silver2;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2805 {
    static int N;
    static int M;
    static int[] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        tree = new int[N];
        for (int i=0; i<N; i++){
            tree[i] = sc.nextInt();
        }
        Arrays.sort(tree);

        int index = binary(tree[N-1]);
        System.out.println(index);
    }
    static int binary(int x){
        int st = 0;
        int en = x;
        int result = 0;

        while(st<=en){
            int mid = (st + en) / 2;
            long sum = 0;

            for (int i=0; i<N; i++){
                if (tree[i] > mid)
                    sum += (tree[i] - mid);
            }

            if (sum >= M){
                result = mid;
                st = mid + 1;
            }
            else{
                en = mid - 1;
            }
        }
        return result;
    }
}
