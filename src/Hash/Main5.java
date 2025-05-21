package Hash;


import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;


class Main5 {
    public Integer solution(int n, int k, int[] arr) {

       TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

       for(int i=0; i < n; i++) {
           for(int j=i+1; j < n; j++) {
               for(int l=j+1; l < n; l++){
                    set.add(arr[i] + arr[j] + arr[l]);
               }
           }
       }

       int cnt = 0;
        for (Integer i : set) {
            cnt++;
            if(cnt == k){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Main5 T = new Main5();
        Scanner kb = new Scanner(System.in);
        int n =kb.nextInt();
        int k =kb.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n,k,arr));
    }
}
