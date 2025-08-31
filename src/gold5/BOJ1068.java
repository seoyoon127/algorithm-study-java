package gold5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] parent = new int[N];
        for (int i=0; i<N; i++){
            parent[i] = sc.nextInt();
        }
        int remove = sc.nextInt();

        int[] afterRemove = parent.clone();
        for (int p=0; p<N; p++){
            int index = p;
            while(index != -1){
                if (index == remove) {
                    afterRemove[p] = -2;
                    System.out.println(p);
                    break;
                }
                else index = parent[index];
            }
        }
        int cnt = 0;
        for (int a=0; a<N; a++){
            int current = a;
            boolean exists = Arrays.stream(afterRemove)
                    .anyMatch(x -> x == current);
            if (!exists && afterRemove[a] != -2){
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}