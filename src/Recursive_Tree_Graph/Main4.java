package Recursive_Tree_Graph;

import com.sun.tools.javac.Main;

import java.util.Scanner;

class Node{
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt = rt = null;
    }

}

public class Main4 {
    Node root;
    public void DFS(Node root){
        if(root == null){
            return;
        }
        else{
            DFS(root.lt);
            DFS(root.rt);
            System.out.print(root.data + " ");
        }

    }
    public static void main(String[] args) {
        Main4 tree = new Main4();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt=new Node(6);
        tree.root.rt.rt=new Node(7);
        tree.DFS(tree.root);


    }




}
