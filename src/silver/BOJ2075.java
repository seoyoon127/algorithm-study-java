package silver;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ2075 {
    static int N;
    static int[] arr;
    static int[] max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N * N; i++) {
            int num = sc.nextInt();
            pq.offer(num);
            if (pq.size() > N) {
                pq.poll(); // N개 초과 시 가장 작은 수 제거
            }
        }

        System.out.println(pq.peek()); // N번째 큰 수
    }
}
