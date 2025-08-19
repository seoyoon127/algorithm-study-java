package gold5;

import java.util.*;

public class BOJ1916 {
    static class Node implements Comparable<Node> {
        int v, cost;
        Node(int v, int cost) { this.v = v; this.cost = cost; }
        public int compareTo(Node o) { return this.cost - o.cost; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, List<Node>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) map.put(i, new ArrayList<>());
        ;
        for(int i=0; i<M; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            map.get(u).add(new Node(v, w));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.cost > dist[cur.v]) continue;

            for (Node next : map.get(cur.v)) {
                if (dist[next.v] > dist[cur.v] + next.cost) {
                    dist[next.v] = dist[cur.v] + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        System.out.println(dist[end]);

    }
}