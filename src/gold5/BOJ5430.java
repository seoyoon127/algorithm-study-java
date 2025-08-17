package gold5;

import java.util.*;

public class BOJ5430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i=0; i<T; i++){
            String[] inst = sc.nextLine().split("");
            int N = sc.nextInt();
            sc.nextLine();

            String input = sc.nextLine();

            long dCount = Arrays.stream(inst)
                    .filter(s -> s.equals("D"))
                    .count();
            if (dCount>N){
                System.out.println("error");
                continue;
            }

            input = input.replaceAll("\\[|\\]", "");
            String[] arr = input.split(",");
            Deque<String> dq = new ArrayDeque<>();

            for (String a : arr){
                if (!a.equals("")){
                    dq.addLast(a);
                }
            }

            boolean front = true;

            for (String in : inst){
                if (in.equals("R")){
                    front = !front;
                }
                else if (in.equals("D")){
                    if (front){
                        dq.pollFirst();
                    }
                    else{
                        dq.pollLast();
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (front){
                int size = dq.size();
                for (int j=0; j<size; j++){
                    sb.append(dq.pollFirst());
                    if (j != size-1) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);

            }
            else{
                List<String> list = new ArrayList<>(dq);
                Collections.reverse(list);
                for (int j=0; j< list.size(); j++){
                    sb.append(list.get(j));
                    if (j!= list.size()-1)
                        sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
