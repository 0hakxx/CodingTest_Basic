package Recursive_Tree_Graph;

class Node9{
    int data;
    Node9 left,right;
    Node9(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main9 {
    Node9 root;

    int minDepth = Integer.MAX_VALUE;

    public void DFS(Node9 root, int depth){
        if(root == null){
            return;
        }
        else{
            if(root.left == null && root.right == null){
                minDepth = Math.min(minDepth, depth);
            }
            else{
                DFS(root.left,depth+1);
                DFS(root.right,depth+1);
            }
        }
    }


    public static void main(String[] args) {
        Main9 tree = new Main9();
        tree.root = new Node9(1);
        tree.root.left = new Node9(2);
        tree.root.right = new Node9(3);
        tree.root.left.left = new Node9(4);
        tree.root.left.right = new Node9(5);
        // 루트 노드의 깊이는 1부터 시작 (혹은 0부터 시작할 수도 있음, 문제 정의에 따라 다름)
        tree.DFS(tree.root, 0);
        System.out.println("루트에서 리프 노드까지의 최소 이동 횟수 (깊이): " + tree.minDepth);
    }
}