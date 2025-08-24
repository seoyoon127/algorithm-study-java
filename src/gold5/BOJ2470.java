package gold5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2470 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        for (int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int left = 0, right = N-1;
        int closeZero = Integer.MAX_VALUE;
        int a = 0, b = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < closeZero) {
                closeZero = Math.abs(sum);
                a = arr[left];
                b = arr[right];
            }
            if (sum < 0) left++;
            else right--;
        }

        System.out.println(a + " " + b);
    }
}