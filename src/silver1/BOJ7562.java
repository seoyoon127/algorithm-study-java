package silver1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7562 {
    static int l;
    static int[] start;
    static int[] end;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            l = sc.nextInt();
            visited = new boolean[l][l];
            start = new int[]{sc.nextInt(), sc.nextInt()};
            end = new int[]{sc.nextInt(), sc.nextInt()};

            System.out.println(move(start[0], start[1]));
        }
    }
    static int move(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,0});
        visited[x][y] = true;

        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};


        while (!queue.isEmpty()){
            int[] p = queue.poll();
            int cx = p[0];
            int cy = p[1];
            int cnt = p[2];

            if (cx == end[0] && cy == end[1]){
                return cnt;
            }

            for (int i=0; i<8; i++){
                int tx = cx + dx[i];
                int ty = cy + dy[i];

                if (tx>=0 && tx<l && ty>=0 && ty<l){
                    if (!visited[tx][ty]){
                        visited[tx][ty] = true;
                        queue.offer(new int[]{tx, ty, cnt+1});
                    }
                }
            }
        }
        return -1;
    }
}
