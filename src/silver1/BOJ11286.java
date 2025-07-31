package silver1;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> plusQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        for (int i=0; i<N; i++){
            int x = sc.nextInt();
            if (x != 0){
                if (x > 0)
                    plusQueue.add(x);
                else
                    minusQueue.add(-x);
            }
            else{
                Integer p = plusQueue.peek();
                Integer m = minusQueue.peek();
                if (p != null && m != null){
                    if (p > m){
                        System.out.println(-m);
                        minusQueue.poll();
                    }
                    else if (p < m){
                        System.out.println(p);
                        plusQueue.poll();
                    }
                    else{
                        System.out.println(-m);
                        minusQueue.poll();
                    }
                }
                else if (m != null){
                    System.out.println(-m);
                    minusQueue.poll();
                }
                else if (p != null){
                    System.out.println(p);
                    plusQueue.poll();
                }
                else{
                    System.out.println(0);
                }
            }
        }
    }
}
