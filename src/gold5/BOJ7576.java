package gold5;

import java.util.*;

public class BOJ7576 {
    static int N,M;
    static int[][] tomato;
    static boolean[][] visited;
    static int zero;
    static int[] dx = {-1, 0, 0, 1 };
    static int[] dy = {0, -1, 1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        tomato = new int[N][M];
        visited = new boolean[N][M];
        zero = 0;
        List<int[]> ones = new ArrayList<>();
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                tomato[i][j] = sc.nextInt();
                if ( tomato[i][j] == 1){
                    ones.add(new int[] {i,j});
                }
                else if (tomato[i][j] == 0){
                    zero += 1;
                }
            }
        }
        if (zero == 0)
            System.out.println(0);
        else
            System.out.println(bfs(ones));

    }
    static int bfs(List<int[]> ones){
        Queue<int[]> queue = new LinkedList<>();
        for (int[] one: ones){
            int x = one[0];
            int y = one[1];
            queue.add(new int[]{x,y,0});
            visited[x][y] = true;
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            for (int i=0; i<4; i++){
                int tx = cx + dx[i];
                int ty = cy + dy[i];

                if (tx >=0 && tx<N && ty >=0 && ty<M && !visited[tx][ty]){
                    visited[tx][ty] = true;
                    if (tomato[tx][ty] == 0){
                        tomato[tx][ty] = 1;
                        zero -= 1;
                        if (zero == 0){
                            return cnt+1;
                        }
                        queue.add(new int[] {tx, ty, cnt+1});
                    }
                }
            }
        }
        return -1;
    }
}
