package gold4;

import java.util.Scanner;

public class BOJ1027 {
    static int countVisible(int N, int[] buildings, int i, int dir) {
        int cnt = 0;
        double min = Double.MAX_VALUE;
        double max = -Double.MAX_VALUE;

        for (int j = i + dir; j >= 0 && j < N; j += dir) {
            int width = Math.abs(i - j);
            int height = Math.abs(buildings[i] - buildings[j]);
            double tan = (double) height / width;

            if (buildings[i] < buildings[j]) { // 더 높은 건물
                if (max < tan) {
                    cnt++;
                    max = tan;
                }
            } else { // 더 낮거나 같은 건물
                if (tan < min && max == -Double.MAX_VALUE) {
                    cnt++;
                    min = tan;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] buildings = new int[N];
        for (int i=0; i<N; i++){
            buildings[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt = countVisible(N, buildings, i, 1) // 오른쪽
                    + countVisible(N, buildings, i, -1); // 왼쪽
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}
