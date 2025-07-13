package silver;

import java.util.HashMap;
import java.util.Scanner;
public class BOJ11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String[] arr = S.split("");
        int len = S.length();
        HashMap<String,Integer> map = new HashMap<String, Integer>();

        for (int i=0; i<len; i++){
            String x = "";
            for (int j=i; j<len; j++){
                x += arr[j];
                map.put(x,1);
            }
        }

        System.out.println(map.size());
    }
}