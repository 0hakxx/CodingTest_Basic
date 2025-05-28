package Recursive_Tree_Graph;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;
class Main14 {
    static int n;
    static int[] ch;
    static int[] arr;
    static int sum = 0;
    public void DFS(int L){
        if(L==n+1){
            String tmp="";
            for(int i=1; i<=n; i++){
                if(ch[i]==1) tmp+=(i+" ");
            }
            if(tmp.length()>0) System.out.println(tmp);
        }
        else{
            ch[L]=1;
            DFS(L+1);
            ch[L]=0;
            DFS(L+1);
        }
    }

    public static void main(String[] args){
        Main14 T = new Main14();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
        }

        ch=new int[n+1];
        T.DFS(1);
    }
}
