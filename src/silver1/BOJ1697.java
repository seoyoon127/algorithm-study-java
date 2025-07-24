package silver1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] visited = new boolean[100001];
        int[] time = new int[100001];
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(N);
        visited[N] = true;
        int node;

        while(!q.isEmpty()){
           int now = q.poll();
           if(now == K) break;

            for (int i=0; i<3; i++){
                if (i==0)
                    node = now - 1;
                else if (i==1)
                    node = now + 1;
                else
                    node = now * 2;

                if (node < 100001 && node >= 0 && !visited[node]){
                    q.offer(node);
                    visited[node] = true;
                    time[node] = time[now] + 1;
                }
            }
        }
        System.out.println(time[K]);
    }
}
