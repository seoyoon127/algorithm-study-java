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
        int[] maxArr = new int[3];
        int[] minArr = new int[3];
        maxArr = arr[0].clone();
        minArr = arr[0].clone();

        for (int i=1; i<N; i++){
            int[] currMax = new int[3];
            int[] currMin = new int[3];
            for (int j=0; j<3; j++){
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int k=0; k<3; k++){
                    int td = j + add[k];
                    if (td >=0 && td<3){
                        max = Math.max(max, maxArr[td]);
                        min = Math.min(min, minArr[td]);
                    }
                }
                currMax[j] = max + arr[i][j];
                currMin[j] = min + arr[i][j];
            }
            maxArr = currMax;
            minArr = currMin;
        }

        int ansMax = Integer.MIN_VALUE;
        int ansMin = Integer.MAX_VALUE;
        for (int i=0; i<3; i++){
            ansMax = Math.max(ansMax, maxArr[i]);
            ansMin = Math.min(ansMin, minArr[i]);
        }
        System.out.println(ansMax + " " + ansMin);
    }
}
