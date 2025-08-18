package gold5;

import java.util.*;

public class BOJ1759 {
    static int L;
    static int C;
    static String[] str;
    static Stack<String> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static List<String> vowel = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        str = sc.nextLine().split(" ");
        Arrays.sort(str);

        combination(0, 0);
        System.out.println(sb);

    }
    static void combination(int idx, int cnt){
        if(cnt == L){
            StringBuilder str = new StringBuilder();
            int vCnt = 0;
            for (String s: stack){
                str.append(s);
                if (vowel.contains(s)){
                    vCnt += 1;
                }
            }
            if (vCnt >= 1 && vCnt <= L-2){
                sb.append(str);
                sb.append("\n");
            }
        }

        for (int i=idx; i<C; i++){
            stack.add(str[i]);
            combination(i+1, cnt+1);
            stack.pop();
        }
    }
}
