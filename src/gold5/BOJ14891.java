package gold5;

import java.util.*;

public class BOJ14891 {
    static List<Integer>[] wheels;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        wheels = new ArrayList[4];
        for (int i=0; i<4; i++){
            String[] wheel = sc.nextLine().split("");
            wheels[i] = new ArrayList<>(8);
            for (String s:wheel){
                wheels[i].add(Integer.parseInt(s));
            }
        }

        int K = sc.nextInt();
        for (int i=0; i<K; i++){
            int wnum = sc.nextInt() - 1;
            int dir = sc.nextInt();

            boolean[] rotates = new boolean[]{wheels[0].get(2) != wheels[1].get(6), wheels[1].get(2) != wheels[2].get(6), wheels[2].get(2) != wheels[3].get(6)};

            int left = wnum - 1;
            int right = wnum + 1;

            rotate(dir, wnum); //현위치

            //왼쪽 전파
            for (int j= left; j>=0; j--){
                if (!rotates[j]) break;
                int d = ((wnum - j) % 2 == 0) ? dir : -dir;
                rotate(d, j);
            }

            //오른쪽 전파
            for (int j= right; j<4; j++){
                if (!rotates[j-1]) break;
                int d = ((wnum - j) % 2 == 0) ? dir : -dir;
                rotate(d, j);
            }
        }
        int score = 0;
        for (int i=0; i<4; i++){
            if(wheels[i].get(0) == 1){
                score += (1 << i);
            }
        }
        System.out.println(score);
    }
    static void rotate(int dir, int num) {
        if (dir == 1) { // 시계
            int last = wheels[num].remove(7);
            wheels[num].add(0, last);
        } else { // 반시계
            int first = wheels[num].remove(0);
            wheels[num].add(first);
        }
    }
}
