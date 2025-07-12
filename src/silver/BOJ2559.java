package silver;

import java.util.Scanner;

public class BOJ2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        long window = 0;
        for (int i=0; i<T; i++) window+=arr[i];
        long max = window;

        for (int i=T; i<N; i++) {
            window = window - arr[i-T] + arr[i];
            if (window > max)
                max = window;
        }
        System.out.println(max);
    }
}
