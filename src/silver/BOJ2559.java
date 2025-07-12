package silver;

import java.util.Scanner;

public class BOJ2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        int N = Integer.parseInt(input1.split(" ")[0]);
        int T = Integer.parseInt(input1.split(" ")[1]);


        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        long ans = 0;
        for(int i=0; i<N-T+1; i++){
            long x = 0;
            for(int j=i; j<i+T; j++){
                x += arr[j];
            }
            if(i==0)
                ans = x;
            else
                ans = Math.max(ans, x);
        }
        System.out.println(ans);
    }
}
