package Recursive_Tree_Graph;

import java.util.Scanner;

public class Main2 {

    public void solution(int n){
        if(n==0){
            return;
        }
        System.out.print(n%2);
        solution(n/2);
    }


    public static void main(String[] args) {
        Main2 main = new Main2();

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        main.solution(n);
        
    }
}
