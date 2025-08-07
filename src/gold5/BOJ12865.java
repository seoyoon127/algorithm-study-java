package gold5;

import java.util.Scanner;

public class BOJ12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] info = new int[N+1][2];
        for (int i=1; i<=N; i++){
            info[i][0] = sc.nextInt();
            info[i][1] = sc.nextInt();
        }

        int[][] arr = new int[N+1][K+1];

        for (int i=1; i<=N; i++){
            for (int j=1; j<=K; j++){
                int wi = info[i][0];
                if (wi > j){
                    arr[i][j] = arr[i-1][j];
                }
                else{
                    arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-wi] + info[i][1]);
                }
            }
        }
        System.out.println(arr[N][K]);
    }
}
