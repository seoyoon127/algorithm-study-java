package silver1;

import java.util.*;

public class BOJ1991 {
    static Map<String, List<String>> map;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new HashMap<>();

        for (int i=0; i<N; i++){
            String Key = sc.next();
            String a = sc.next();
            String b = sc.next();
            map.put(Key, new ArrayList<>());
            map.get(Key).add(a);
            map.get(Key).add(b);
        }
        sb = new StringBuilder();
        preorder("A");
        System.out.println(sb);

        sb = new StringBuilder();
        inorder("A");
        System.out.println(sb);

        sb = new StringBuilder();
        postorder("A");
        System.out.println(sb);

    }
    static void preorder(String node){
        if (node.equals("."))return;
        sb.append(node);
        preorder(map.get(node).get(0));
        preorder(map.get(node).get(1));
    }
    static void inorder(String node){
        if (node.equals("."))return;
        inorder(map.get(node).get(0));
        sb.append(node);
        inorder(map.get(node).get(1));
    }
    static void postorder(String node){
        if (node.equals("."))return;
        postorder(map.get(node).get(0));
        postorder(map.get(node).get(1));
        sb.append(node);
    }
}
