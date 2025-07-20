package silver2;

import java.util.Scanner;

public class BOJ4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            boolean[] arr = new boolean[2*n+1];
            arr[0] = arr[1] = true;
            for (int i=2; i<=2*n; i++){
                if (arr[i]) continue;
                for(int j=2*i;j<=2*n; j+=i) {
                    arr[j] = true;
                }
            }
            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!arr[i]) count++;
            }
            System.out.println(count);
        }
    }
}
