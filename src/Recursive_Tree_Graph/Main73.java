package Recursive_Tree_Graph;
import com.sun.tools.javac.Main;

import java.util.*;


class Main73 {
    static int n, total;
    static int max= Integer.MIN_VALUE;

    boolean flag = false;
    public void DFS(int L, int sum, int[] arr){
        if(sum > total){
            return;
        }
        if(L == n){max = Math.max(max, sum);}
        else{
          DFS(L+1, sum+arr[L], arr);
          DFS(L+1, sum, arr);
      }
    }



    public static void main(String[] args) {
        Main73 m = new Main73();
        Scanner sc = new Scanner(System.in);
        total = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m.DFS(0,0,arr);
        System.out.println(max);
    }
}