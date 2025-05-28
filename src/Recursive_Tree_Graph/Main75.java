package Recursive_Tree_Graph;

import java.util.Scanner;


class Main75 {
    static int n;
    static int time_total;
    static int answer= Integer.MIN_VALUE;


    public void DFS(int L, int sum, int sumtime, int[] score, int[] time) {
        if(L == n ){
            if(sumtime <= time_total){
                answer = Math.max(sum, answer);
            }
        }
        else{
            DFS(L+1, sum+score[L], sumtime+time[L], score, time);
            DFS(L+1, sum, sumtime, score, time);
        }

    }



    public static void main(String[] args) {
        Main75 m = new Main75();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        time_total = sc.nextInt();

        int[] score = new int[n];
        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }

        m.DFS(0,0,0, score, time);
        System.out.println(answer);
    }
}