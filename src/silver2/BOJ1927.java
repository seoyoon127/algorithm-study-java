package silver2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;  i<N; i++){
            int x = sc.nextInt();
            if (x != 0){
                pq.offer(x);
            }
            else{
                Integer val = pq.poll();
                int print = (val == null) ? 0 : val;
                System.out.println(print);
            }
        }

    }
}
