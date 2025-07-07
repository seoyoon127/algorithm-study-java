package bronze;

import java.util.Scanner;

public class BOJ1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int oriNum = N;
        int nextNum = 0;
        int cnt = 0;

        while(true){
            cnt += 1;
            int a = oriNum / 10;
            int b = oriNum % 10;
            nextNum = b * 10 + ((a+b) % 10);

            if (nextNum == N)
                break;
            oriNum = nextNum;
        }
        System.out.println(cnt);
    }
}
