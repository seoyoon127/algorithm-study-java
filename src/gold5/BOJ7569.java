package gold5;

import java.util.*;

public class BOJ7569 {
    static int N,M,H;
    static int[][][] tomato;
    static boolean[][][] visited;
    static int zero;
    static int[] dx = {-1, 0, 0, 1, 0, 0};
    static int[] dy = {0, -1, 1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];
        List<int[]> ones = new ArrayList<>();
        for(int h=0; h<H; h++) {
            for (int i=0; i<N; i++){
                for (int j=0; j<M; j++){
                    tomato[h][i][j] = sc.nextInt();
                    if (tomato[h][i][j] == 0) zero += 1;
                    else if (tomato[h][i][j] == 1) ones.add(new int[]{h, i,j,0});
                }
            }
        }
        if (zero == 0) System.out.println(0);
        else System.out.println(bfs(ones));
    }

    static int bfs(List<int[]> ones){
        Queue<int[]> queue = new LinkedList<>();
        for (int[] one : ones) {
            queue.add(new int[]{one[0], one[1], one[2], one[3]});
            visited[one[0]][one[1]][one[2]] = true;
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int ch = cur[0];
            int cx = cur[1];
            int cy = cur[2];
            int cnt = cur[3];

            for (int i=0; i<6; i++){
                int tx = cx + dx[i];
                int ty = cy + dy[i];
                int th = ch + dh[i];

                if (tx>=0 && tx<N && ty>=0 && ty<M && th>=0 && th<H){
                    if (!visited[th][tx][ty] && tomato[th][tx][ty] == 0){
                        tomato[th][tx][ty] = 1;
                        queue.add(new int[]{th, tx, ty, cnt+1});
                        visited[th][tx][ty] = true;
                        zero--;
                        if (zero == 0) return cnt+1;
                    }
                }
            }
        }
        return -1;
    }
}
