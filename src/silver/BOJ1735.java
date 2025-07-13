package silver;

import java.util.Scanner;

public class BOJ1735 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();

        int A = a1 * b2 + a2 * b1;
        int B = b1 * b2;

        if (A == B){
            A = 1;
            B = 1;
        }else{
            for (int i=Math.min(A,B); i>=2; i--){
                if (A%i == 0 && B%i == 0){
                    A = A/i;
                    B = B/i;
                }
            }
        }

        System.out.println(A + " " + B);
    }
}
