package Recursive_Tree_Graph;

import java.util.Scanner;

public class Main3 {

    public int solution(int n){
        if(n==1){
            return 1;
        }
        else return n*solution(n-1);
    }


    public static void main(String[] args) {
        Main3 main = new Main3();

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println(main.solution(n));
        
    }
}
