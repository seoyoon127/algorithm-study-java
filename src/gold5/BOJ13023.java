package gold5;

import java.util.*;

public class BOJ13023 {
    static boolean found;
    static Map<Integer, List<Integer>> map;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
       map = new HashMap<>();
        for (int i=0; i<N; i++){
            map.put(i, new ArrayList<>());
        }
        for (int i=0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.get(x).add(y);
            map.get(y).add(x);
        }
        int ans = 0;
        for (int i=0; i<N; i++){
            visited = new boolean[N];
            dfs(i, 1);
            if (found) {
                ans = 1;
                break;
            }
        }
        System.out.println(ans);

    }
    static void dfs(int k, int cnt){
        if (cnt == 5) {
            found = true;
            return;
        }
        visited[k] = true;
        for (int x : map.get(k)){
            if (!visited[x]){
                dfs(x, cnt+1);
            }
        }
        visited[k] = false;
    }
}
