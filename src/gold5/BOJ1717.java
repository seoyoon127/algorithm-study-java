package gold5;

import java.util.Scanner;

public class BOJ1717 {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n+1];

        for (int i=0; i<=n; i++){
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<m; i++){
            int x = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (x == 0){
                union(a,b);
            }
            else{
                sb.append(find(a) == find(b) ? "YES\n" : "NO\n");
            }
        }
        System.out.println(sb);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    static int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
