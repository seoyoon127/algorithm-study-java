package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();

        Arrays.sort(arr);

        int cnt = 0;
        int s = 0;
        int e =  n-1;

        while(true){
            if (s >= e){
                break;
            }
            int sum = arr[s] + arr[e];
            if (sum == x) {
                cnt += 1;
                s++;
                e--;
            } else if (sum < x){
                s++;
            }else{
                e--;
            }
        }

        System.out.println(cnt);
    }
}
