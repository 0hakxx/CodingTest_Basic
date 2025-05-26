package Recursive_Tree_Graph;



import java.util.ArrayDeque;

import java.util.Deque;



class Node10{

    int data;

    Node10 left,right;

    Node10(int data){

        this.data = data;

        this.left = null;

        this.right = null;

    }

}



public class Main10 {

    Node10 root;

    int depth = 0;

    public int BFS(Node10 node){
        Deque<Node10> queue = new ArrayDeque<>();

        queue.offer(node);

        int depth = 0; // 루트 노드부터 깊이

        while(!queue.isEmpty()){
            int levelSize = queue.size(); // 현재 레벨의 노드 개수
// 현재 레벨의 모든 노드 처리

            for(int i = 0; i < levelSize; i++){

                Node10 current = queue.poll();



// 리프 노드 발견시 현재 깊이 반환

                if(current.left == null && current.right == null){

                    return depth;

                }



// 자식 노드가 있으면 큐에 추가

                if(current.left != null) queue.offer(current.left);

                if(current.right != null) queue.offer(current.right);

            }

            depth++; // 다음 레벨로 이동

        }

        return depth;

    }






    public static void main(String[] args) {

        Main10 tree = new Main10();

        tree.root = new Node10(1);

        tree.root.left = new Node10(2);

        tree.root.right = new Node10(3);

        tree.root.left.left = new Node10(4);

        tree.root.left.right = new Node10(5);

// 루트 노드의 깊이는 1부터 시작 (혹은 0부터 시작할 수도 있음, 문제 정의에 따라 다름)

        System.out.println(tree.BFS(tree.root));

    }

}