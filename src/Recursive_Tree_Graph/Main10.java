package Recursive_Tree_Graph;

import java.util.Deque;
import java.util.LinkedList;

class Node10 {
    int data;
    Node10 left, right;

    Node10(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Main10 {
    Node10 root;

    public int BFS(Node10 root) {
        if (root == null) {
            return 0; // 트리가 비어있으면 깊이는 0
        }

        Deque<Node10> queue = new LinkedList<>();
        queue.offer(root); // 루트 노드를 큐에 추가
        int level = 0; // 레벨 (깊이) 추적. 루트 노드를 깊이 0으로 시작하면 0, 1로 시작하면 1

        while (!queue.isEmpty()) {
            // 현재 레벨의 노드 개수
            int levelSize = queue.size();
            level++; // 다음 레벨로 이동하기 전에 깊이를 증가

            // 현재 레벨의 모든 노드를 처리
            for (int i = 0; i < levelSize; i++) {
                Node10 currentNode = queue.poll();

                // 현재 노드가 리프 노드인지 확인 (최소 깊이를 찾는 경우)
                if (currentNode.left == null && currentNode.right == null) {
                    return level; // 첫 번째로 발견되는 리프 노드의 깊이가 최소 깊이
                }

                // 왼쪽 자식이 있으면 큐에 추가
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                // 오른쪽 자식이 있으면 큐에 추가
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            // 이 지점에서 현재 레벨의 모든 노드 처리가 완료되었고, 다음 레벨의 노드들이 큐에 들어있다.
        }
        return level; // 모든 노드를 탐색했지만 (이 코드가 실행될 일은 거의 없지만) 마지막 레벨 반환
    }

    public static void main(String[] args) {
        Main10 tree = new Main10();
        tree.root = new Node10(1);
        tree.root.left = new Node10(2);
        tree.root.right = new Node10(3);
        tree.root.left.left = new Node10(4);
        tree.root.left.right = new Node10(5);
        tree.root.right.left = new Node10(6); // 테스트를 위해 추가
        tree.root.right.right = new Node10(7); // 테스트를 위해 추가
        tree.root.right.right.left = new Node10(8); // 더 깊은 리프 노드 추가

        System.out.println("루트에서 리프 노드까지의 최소 이동 횟수 (깊이): " + tree.BFS(tree.root));
    }
}