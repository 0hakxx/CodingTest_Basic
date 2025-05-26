package Recursive_Tree_Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Main12 {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] check;


    public void DFS(int v) {
        if(v==n){answer++;}
        else {
            for(int nv : graph.get(v)) {
                if(check[nv] == 0){
                    check[nv] = 1;
                    DFS(nv);
                    check[nv] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        Main12 T = new Main12();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        check = new int[n+1]; // check 배열 초기화
        check[1] = 1;         // 시작 노드 1을 방문 처리
        T.DFS(1);
        System.out.println(answer);


    }
}
