package gold5;

import java.util.Scanner;

public class BOJ2447 {
    static int N;
    static int[][] star;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        star = new int[N][N];
        sb = new StringBuilder();

        recur(N,0,0);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if (star[i][j] == 0){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    static void recur(int n, int x, int y) {
        if (n == 1) {
            return;
        }

        int size = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    // 가운데 칸은 공백 처리
                    for (int a = x + size; a < x + size * 2; a++) {
                        for (int b = y + size; b < y + size * 2; b++) {
                            star[a][b] = 1; // 1은 공백
                        }
                    }
                } else {
                    // 나머지 칸은 재귀 호출
                    recur(size, x + i * size, y + j * size);
                }
            }
        }
    }
}
