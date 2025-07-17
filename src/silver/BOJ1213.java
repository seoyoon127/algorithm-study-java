package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String[] str = S.split("");
        Arrays.sort(str);

        String center = "";
        StringBuilder ans = new StringBuilder();
        String[] par = new String[S.length()/2];
        int index = 0;

        for (int i=0; i<S.length(); i++){
            String s = str[i];
            if (Arrays.stream(par).anyMatch(x -> x != null && x.equals(s))) {
                continue;
            }
            long cnt = Arrays.stream(str).filter(x -> x.equals(s)).count();
            if( cnt % 2 == 1){
                if (center.isEmpty()) {
                    center = str[i];
                    for (int j = 0; j<cnt/2; j++){
                        par[index++] = str[i];
                    }
                }
                else{
                    ans.append("I'm Sorry Hansoo");
                    break;
                }
            }
            else{
                for (int j = 0; j<cnt/2; j++){
                    par[index++] = str[i];
                }
            }
        }
        if (ans.isEmpty()){
            for (String p : par){
                ans.append(p);
            }
            ans.append(center);
            for (int i = par.length - 1; i >= 0; i--) {
                ans.append(par[i]);
            }
        }
        System.out.println(ans);
    }
}
