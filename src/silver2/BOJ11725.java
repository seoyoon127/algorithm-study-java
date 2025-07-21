package silver2;

import java.util.*;

public class BOJ11725 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i=0; i<N-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] parent = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    queue.offer(next);
                }
            }
        }

        for (int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }
}
