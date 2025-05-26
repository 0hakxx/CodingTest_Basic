package Recursive_Tree_Graph;

import java.util.Scanner;

public class Main6 {

    static int n;
    static char[] ch;

    public void DFS(int L) {
        String tmp = "";
        if (L == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += i + " ";
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }

    }


    public static void main(String[] args) {
        Main6 T = new Main6();

        Scanner scanner = new Scanner(System.in);

        n = 3;
        ch = new char[n+1];
        T.DFS(1);
        
    }
}
