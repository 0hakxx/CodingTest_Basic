package Recursive_Tree_Graph;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class Main11 {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] check;
    public int DFS(int v){

        if(v==n){
            answer++;
        }
        else {
            for(int i=1; i <= n; i++){
                if(graph[v][i]==1 && check[i]==0){
                    check[i] = 1;
                    DFS(i);
                    check[i] = 0;
                }
            }
        }

    }

    public static void main(String[] args){
        Main11 T = new Main11();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n+1][n+1];
        check = new int[n+1];
        for(int i = 1; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        check[1] = 1;
        T.DFS(1);
        System.out.println(answer);


    }
}
