package Recursive_Tree_Graph;

import java.util.Scanner;


class Main79 {
    static int memory[][];


    public int DFS(int n, int r) {
        if(memory[n][r] > 0) {
            return memory[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        else{
            return memory[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }


    public static void main(String[] args) {
        Main79 solver = new Main79();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        memory = new int[n+1][r+1];

        System.out.print(solver.DFS(n, r));

        scanner.close(); // 입력 스트림 닫기
    }
}