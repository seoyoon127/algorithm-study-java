package silver2;

import java.util.*;

public class BOJ11724 {
    static List<List<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        graph = new ArrayList<>();

        for (int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N + 1];
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    static void dfs(int n){
        visited[n] = true;
        for (int next :graph.get(n)){
            if (!visited[next])
                dfs(next);
        }
    }
}
