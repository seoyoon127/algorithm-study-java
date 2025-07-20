package silver2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<N; i++){
            int x =  sc.nextInt();
            if (x == 0){
                System.out.println(pq.isEmpty() ? 0 : pq.poll());
            }
            else
                pq.add(x);
        }
    }
}
