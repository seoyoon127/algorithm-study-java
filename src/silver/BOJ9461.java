package silver;

import java.util.Scanner;

public class BOJ9461 {
    static long p[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];
        for (int i=0; i<T; i++){
            arr[i] = sc.nextInt();
        }
        p =  new long[101];

        for (int a : arr){
            System.out.println(getP(a));
        }
    }

    static long getP(int n){
        if (n<=3)
            return 1;
        else if (n<=5)
            return 2;
        else if (p[n] == 0){
            p[n] = getP(n-1) + getP(n-5);
        }
        return p[n];
    }

}
