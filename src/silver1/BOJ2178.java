package silver1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {
    static int[][] arr;
    static int N, M;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] length;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N ][M];
        visited = new boolean[N][M];
        length = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<int[]>();

        q.offer(new int[] {i,j});
        visited[i][j] = true;
        length[i][j] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int x = 0; x < 4; x++) {
                int nx = cx + dx[x];
                int ny = cy + dy[x];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && arr[nx][ny] == 1) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        length[nx][ny] = length[cx][cy] + 1;
                    }
                }
            }
        }
        return length[N-1][M-1];
    }
}
