package Recursive_Tree_Graph;

import java.util.Scanner;

public class Main1 {

    public void solution(int n){
        if (n == 0) {
            return;
        }
        solution(n - 1);
        System.out.println(n);
    }


    public static void main(String[] args) {
        Main1 main = new Main1();

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        main.solution(n);
        
    }
}
