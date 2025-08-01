package silver;

import java.util.Scanner;
import java.util.Stack;

public class BOJ15652 {
    static int N;
    static StringBuilder sb;
    static Stack<Integer> stack;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();

        sb = new StringBuilder();
        stack = new Stack<>();
        combination(1,0,M);
        System.out.println(sb);

    }
    static void combination(int idx, int selected, int r){
        if (selected == r){
            for (int i : stack){
                sb.append(i);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i=idx; i<=N; i++){
            stack.add(i);
            combination(i, selected+1, r);
            stack.pop();
        }
    }
}
