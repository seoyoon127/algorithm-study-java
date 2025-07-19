package silver2;

import java.util.*;


public class BOJ18870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        for (int a : arr){
            set.add(a);
        }

        List<Integer> sortArr = new ArrayList<>(set);
        Collections.sort(sortArr);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<sortArr.size(); i++){
            map.put(sortArr.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}
