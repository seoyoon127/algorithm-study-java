package silver1;

import java.util.*;

public class BOJ2468 {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        int maxHeight = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                arr[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        int maxSafeArea = 0;

        for (int rain = 0; rain <= maxHeight; rain++) {
            visited = new boolean[N][N];
            int safeArea = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] > rain) {
                        bfs(i, j, rain);
                        safeArea += 1;
                    }
                }
            }
            maxSafeArea = Math.max(maxSafeArea, safeArea);
        }

        System.out.println(maxSafeArea);
    }

    static void bfs (int x, int y, int rain){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int nx = cur[0];
            int ny = cur[1];

            for (int i=0; i<4; i++){
                int tx = nx + dx[i];
                int ty = ny + dy[i];
                if (tx>=0 && tx<N && ty>=0 && ty<N){
                    if (!visited[tx][ty] && arr[tx][ty] > rain){
                        queue.offer(new int[]{tx, ty});
                        visited[tx][ty] = true;
                    }
                }
            }
        }
    }
}
