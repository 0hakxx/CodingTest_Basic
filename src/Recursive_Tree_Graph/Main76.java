package Recursive_Tree_Graph;

import java.util.AbstractQueue;
import java.util.Scanner;


class Main76 {
    static int m;
    static int n;
    static int arr[];


    public void DFS(int L) {
        if(L == m){
            for(int x : arr)
                System.out.print(x + " ");
                System.out.println();
        }
        else{
            for(int i=1; i<=n; i++){
                arr[L] = i;
                DFS(L+1);
            }
            }
        }



    public static void main(String[] args) {
        Main76 T = new Main76();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //조합하려는 자연수
        m = sc.nextInt(); //개수
        arr = new int[m];

        T.DFS(0);




    }
}