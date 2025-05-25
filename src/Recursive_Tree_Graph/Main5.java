package Recursive_Tree_Graph;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {

    static int n;
    static char[] ch;

    public void DFS(int L) {
        String tmp = "";
        if (L == n + 1) {
            for (int i = 1; i <= ch.length; i++) {
                if (ch[i] == 1) {
                    tmp += i;
                }
            }
            if (tmp.length() > 0) {
                System.out.print(tmp);
            }
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }

    }


    public static void main(String[] args) {
        Main5 T = new Main5();

        Scanner scanner = new Scanner(System.in);

        n = 3;
        ch = new char[n+1];
        T.DFS(1);
        
    }
}
