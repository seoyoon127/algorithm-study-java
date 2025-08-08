package gold5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ10026 {
    static int N;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static String[][] arr;
    static boolean[][][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new String[N][N];
        sc.nextLine();
        for (int i=0; i<N; i++){
            arr[i] = sc.nextLine().split("");
        }
        visited = new boolean[N][N][2];

        int ncnt = 0;
        int cnt = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (!visited[i][j][0] && arr[i][j].equals("B")){
                    bfs(i,j, new String[]{"B"}, 0);
                    ncnt ++;
                    cnt ++;
                }
                else{
                    if (!visited[i][j][0] && arr[i][j].equals("R")){
                        bfs(i,j, new String[]{"R"}, 0);
                        ncnt ++;
                    }
                    else if (!visited[i][j][0] && arr[i][j].equals("G")){
                        bfs(i,j, new String[]{"G"}, 0);
                        ncnt ++;
                    }
                    if(!visited[i][j][1]){
                        bfs(i,j, new String[]{"R","G"}, 1);
                        cnt ++;
                    }
                }
            }
        }
        System.out.println(ncnt + " " + cnt);
    }
    static void bfs(int x, int y, String[] w, int v){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y][v] = true;
        if (arr[x][y].equals("B")) visited[x][y][1] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i=0; i<4; i++){
                int tx = cx + dx[i];
                int ty = cy + dy[i];

                if (tx>=0 && tx<N && ty>=0 && ty<N){
                    if(!visited[tx][ty][v] && Arrays.stream(w).anyMatch(s -> s.equals(arr[tx][ty]))){
                        queue.add(new int[]{tx,ty});
                        if (arr[tx][ty].equals("B")) {
                            visited[tx][ty][1] = true;
                        }
                        visited[tx][ty][v] = true;
                    }
                }
            }
        }
    }
}
