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
    // Integer.MAX_VALUE로 초기화하여 최소값을 찾을 준비
    int minDepth = Integer.MAX_VALUE;

    Node9 root;

    // DFS 함수를 수정하여 현재까지의 깊이(이동 횟수)를 파라미터로 받음
    public void DFS(Node9 root, int depth){
        if(root == null){
            return;
        }

        // 현재 노드가 리프 노드인 경우 (자식 노드가 모두 null)
        if(root.left == null && root.right == null){
            // 현재 깊이가 이전에 찾은 최소 깊이보다 작으면 업데이트
            minDepth = Math.min(minDepth, depth);
        } else {
            // 리프 노드가 아니면 왼쪽, 오른쪽 자식으로 이동하며 깊이 증가
            DFS(root.left, depth + 1);
            DFS(root.right, depth + 1);
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
        tree.DFS(tree.root, 1);
        System.out.println("루트에서 리프 노드까지의 최소 이동 횟수 (깊이): " + tree.minDepth);
    }
}