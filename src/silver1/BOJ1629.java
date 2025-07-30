package silver1;

import java.util.Scanner;

public class BOJ1629 {
    static int C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        C = sc.nextInt();

        long  ans = pow(A,B);
        System.out.println((int) (ans % C));
    }
    static long  pow(long  a, long  b){
        if (b == 0) return 1;
        long temp = pow(a, b / 2);
        temp = (temp * temp) % C;

        if (b % 2 == 1) {
            return (temp * a) % C;
        } else {
            return temp;
        }
    }
}
