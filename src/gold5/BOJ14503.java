package gold5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14503 {
    static int N,M;
    static int cnt;
    static int[][] room;
    static boolean[][] visited;
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        room = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                room[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[N][M];

        bfs(r,c,d);
        System.out.println(cnt);

    }
    static void bfs(int x, int y, int d){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,d});
        if (!visited[x][y] && room[x][y]==0) cnt+=1;
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cd = cur[2];

            boolean move = false;
            for (int i=cd+3; i>=cd; i--){
                int tx = cx + dx[i%4];
                int ty = cy + dy[i%4];
                if (tx>=0 && tx<N && ty>=0 && ty<M){
                    if (!visited[tx][ty] && room[tx][ty] == 0){
                        move = true;
                        cnt += 1;
                        visited[tx][ty] = true;
                        queue.add(new int[]{tx,ty,i%4});
                        break;
                    }
                }
            }
            if (!move){
                int tx = cx + dx[(cd+2)%4];
                int ty = cy + dy[(cd+2)%4];
                if (tx>=0 && tx<N && ty>=0 && ty<M && room[tx][ty] == 0){
                    queue.add(new int[]{tx,ty,cd});
                }
                else{
                    break;
                }
            }
        }
    }
}
