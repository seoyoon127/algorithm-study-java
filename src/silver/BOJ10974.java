package silver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ10974 {
    static int N;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N + 1];

        int[] cur = new int[N];
        dfs(0, cur);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }
    static void dfs(int depth, int[] cur) {
        if (depth == N) {                // 순열 완성
            for (int i = 0; i < N; i++) {
                sb.append(cur[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur[depth] = i;
                dfs(depth + 1, cur);
                visited[i] = false;      // 백트래킹
            }
        }
    }
}
