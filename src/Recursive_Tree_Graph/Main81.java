package Recursive_Tree_Graph;


import java.util.Scanner;

class Main81 {

    static int N;
    static int M;
    static int combi[];

    public void DFS(int level, int start){
        if(level == M){
            for(int x : combi){
                System.out.print(x+" ");
            }
            System.out.println();
        }
        else {
            for(int i=start; i <= N; i++){
                combi[level] = i;
                DFS(level+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Main81 T = new Main81();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        combi = new int[M];

        T.DFS(0,1);


    }
}