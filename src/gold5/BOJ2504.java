package gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Object> stack = new Stack<>();

        for (char c : input.toCharArray()){
            if (c == '(' || c == '['){
                stack.add(c);
            }
            else{
                int mul = c == ')' ? 2 : 3;
                char open = c == ')' ? '(' : '[';
                if (stack.isEmpty()) {
                    System.out.println(0);
                    return;
                }
                int temp = 0;
                boolean found = false;
                while (!stack.isEmpty()){
                    Object peek = stack.pop();
                    if (peek instanceof Integer){
                        temp += (Integer) peek;
                    }
                    else if ((char) peek == open){
                        if (temp == 0) stack.push(mul);
                        else stack.push(temp * mul);
                        found = true;
                        break;
                    }
                    else{
                        System.out.println(0);
                        return;
                    }
                }
                if (!found) {
                    System.out.println(0);
                    return;
                }
            }
        }
        int ans = 0;
        while (!stack.isEmpty()){
            Object peek = stack.pop();
            if (peek instanceof Integer){
                ans += (Integer) peek;
            }
            else{
                System.out.println(0);
                return;
            }
        }
        System.out.println(ans);
    }
}