package silver2;

import java.util.*;

public class BOJ2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
            Integer x = map.get(arr[i]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr);

        //1. 산술 평균
        System.out.println(Math.round((double)sum / N));

        //2. 중앙값
        System.out.println(arr[N/2]);

        //3. 최빈값
        LinkedList<Integer> max = new LinkedList<>();
        for (Integer key : map.keySet()) {
            if (max.isEmpty()) {
                max.add(key);
                continue;
            }
            int freq = map.get(key);
            int maxFreq = map.get(max.get(0));
            if (freq > maxFreq){
                max.clear();
            }
            if (freq >= maxFreq){
                max.add(key);
            }
        }
        Collections.sort(max);
        System.out.println(max.size()>=2 ? max.get(1) : max.get(0));

        //4. 범위
        System.out.println(arr[N-1] - arr[0]);

    }
}
