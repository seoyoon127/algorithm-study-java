package silver;

import java.util.Scanner;

public class BOJ2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;

        while(true){
            if ( N < 0 ){
                cnt = -1;
                break;
            }
            if ( N % 3 == 0 && N < 15 ) {
                cnt += (N / 3);
                break;
            }
            N -= 5;
            cnt += 1;
        }
        System.out.println(cnt);
    }
}
