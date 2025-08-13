package gold5;

import java.util.Scanner;

public class BOJ9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split("");
        String[] str2 = sc.nextLine().split("");

        int[][] dp = new int[str1.length+1][str2.length+1];
        for (int i=1; i<= str1.length; i++){
            for (int j=1; j<= str2.length; j++){
                if (str1[i-1].equals(str2[j-1])){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[str1.length][str2.length]);
    }
}
