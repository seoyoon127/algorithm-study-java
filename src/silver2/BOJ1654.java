package silver2;

import java.util.Scanner;

public class BOJ1654 {
    static int N;
    static int K;
    static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new long[N];
        long max = 0;
        for (int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            if (arr[i]>max)
                max = arr[i];
        }

        long index = binary(max);
        System.out.println(index);
    }
    static long binary(long x){
        long st = 1;
        long en = x;
        long result = 0;

        while(st<=en){
            int cnt = 0;
            long mid = (st + en) / 2;

            for (int i=0; i<N; i++){
                cnt += arr[i]/mid;
            }
            if (cnt >= K){
                result = mid;
                st = mid + 1;
            }
            else {
                en = mid - 1;
            }
        }
        return result;
    }
}
