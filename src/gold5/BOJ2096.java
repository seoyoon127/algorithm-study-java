package gold5;

import java.util.Scanner;

public class BOJ2096 {
    static int[] add = new int[]{-1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][3];
        for (int i=0; i<N; i++){
            for (int j=0; j<3; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] maxArr = new int[N][3];
        int[][] minArr = new int[N][3];
        maxArr[0] = arr[0].clone();
        minArr[0] = arr[0].clone();

        for (int i=1; i<N; i++){
            for (int j=0; j<3; j++){
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int k=0; k<3; k++){
                    int td = j + add[k];
                    if (td >=0 && td<3){
                        max = Math.max(max, maxArr[i-1][td]);
                        min = Math.min(min, minArr[i-1][td]);
                    }
                }
                maxArr[i][j] = max + arr[i][j];
                minArr[i][j] = min + arr[i][j];
            }
        }

        int ansMax = Integer.MIN_VALUE;
        int ansMin = Integer.MAX_VALUE;
        for (int i=0; i<3; i++){
            ansMax = Math.max(ansMax, maxArr[N-1][i]);
            ansMin = Math.min(ansMin, minArr[N-1][i]);
        }
        System.out.println(ansMax + " " + ansMin);
    }
}
