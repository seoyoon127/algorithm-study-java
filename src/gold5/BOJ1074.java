package gold5;

import java.util.Scanner;

public class BOJ1074 {
    static int[][] arr;
    static int r;
    static int c;
    static int visited = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        recur(N, 0, 0);

    }
    public static void recur(int n, int x, int y){
        if (n==0){
            System.out.println(visited);
            return;
        }
        int size = (1 << n) / 2;
        if (r>=x && r<x+size && c>=y && c<y+size){
            recur(n-1, x, y);
        }
        else if (r>=x && r<x+size && c>=y+size && c<y+2*size){
            visited += size*size;
            recur(n-1, x, y+size);
        }
        else if (r>=x+size && r<x+2*size && c>=y && c<y+size){
            visited += size*size*2;
            recur(n-1, x+size, y);
        }
        else if (r>=x+size && r<x+2*size && c>=y+size && c<y+2*size){
            visited += size*size*3;
            recur(n-1, x+size, y+size);
        }
    }
}
