package TwoPointer;

import java.util.ArrayList;
import java.util.Scanner;


public class Main1 {

    public ArrayList<Integer> solution(int first, int second, int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();
        int i=0; int j=0;

        while(i<first && j<second){
            if(a[i] < b[j]){
                res.add(a[i++]);
            }
            else {res.add(b[j++]);}
        }

        while(i<first){
            res.add(a[i++]);
        }
        while(j<second){
            res.add(b[j++]);
        }
        return res;
    }

    public static void main(String[] args) {
        Main1 T = new Main1();
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt(); // 사용자로부터 배열 크기 입력받음
        int a[] = new int[first];

        for(int i = 0; i < first; i++) {
            a[i] = sc.nextInt();
        }
        int second = sc.nextInt(); // 사용자로부터 배열 크기 입력받음
        int b[] = new int[second];

        for(int i = 0; i < second; i++) {
            b[i] = sc.nextInt();
        }


        for (int i : T.solution(first, second, a,b)) {
            System.out.print(i + " ");
        }
    }
}
