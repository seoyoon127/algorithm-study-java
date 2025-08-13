package gold5;

import java.util.*;

public class BOJ15686 {
    static int N;
    static int M;
    static List<int[]> chicken;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) chicken.add(new int[]{i,j});
            }
        }

        Stack<int[]> selected = new Stack<>();
        combination(0, 0, selected);

        System.out.println(answer);

    }
    static void combination(int idx, int count, Stack<int[]> selected) {
        if (count == M) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) { // 집이면
                        sum += getDistanceToNearestChicken(i, j, selected);
                    }
                }
            }
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            selected.push(chicken.get(i));
            combination(i + 1, count + 1, selected);
            selected.pop(); // 백트래킹
        }
    }
    static int getDistanceToNearestChicken(int x, int y, Stack<int[]> selected) {
        int minDist = Integer.MAX_VALUE;
        for (int[] c : selected) {
            int dist = Math.abs(x - c[0]) + Math.abs(y - c[1]);
            minDist = Math.min(minDist, dist);
        }
        return minDist;
    }
}
