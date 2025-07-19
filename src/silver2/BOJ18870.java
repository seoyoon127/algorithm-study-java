package silver2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ18870 {
    static int N;
    static int[] sortArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int[N];

        Set<Integer> set = new LinkedHashSet<>();
        for (int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }

        sortArr = new int[set.size()];
        int index = 0;
        for (int s : set){
            sortArr[index++] = s;
        }
        Arrays.sort(sortArr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(binary(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
    static int binary(int a){
        int st = 0;
        int en = sortArr.length-1;
        int result = 0;

        while(st <= en){
            int mid = (st + en)/2;

            if (sortArr[mid] < a){
                st = mid + 1;
            }
            else if (sortArr[mid] > a){
                en = mid - 1;
            }
            else{
                result = mid;
                break;
            }
        }
        return result;
    }
}
