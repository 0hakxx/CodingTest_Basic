package Recursive_Tree_Graph;

import java.util.ArrayDeque;
import java.util.Deque;

class Node2 {
    int data;
    Node2 lt, rt;
    // 'lt'는 'left' (왼쪽 자식)를, 'rt'는 'right' (오른쪽 자식)를 가리킵니다.

    // Node2 클래스의 '생성자'입니다. 노드를 새로 만들 때 어떻게 초기화할지 정해주는 특별한 메서드예요.
    public Node2(int val){ // 'val'은 이 노드에 저장할 값을 의미합니다.
        this.data = val; // 새로 만들 노드의 'data' 변수에 'val' 값을 넣습니다. (예: new Node2(1) 이면 data에 1이 들어감)
        this.lt = null;  // 처음에는 왼쪽 자식이 없으므로, 'null' (아무것도 가리키지 않음)로 설정합니다.
        this.rt = null;  // 처음에는 오른쪽 자식이 없으므로, 'null' (아무것도 가리키지 않음)로 설정합니다.
    }
}




public class Main7 {
    Node2 root; // 트리의 가장 꼭대기에 있는 노드(뿌리 노드)를 저장할 변수입니다.


    public void BFS(Node2 root){
        // '큐(Queue)'를 하나 만듭니다. 이 큐는 우리가 다음으로 방문할 노드들을 임시로 저장해두는 '대기열' 역할을 합니다.
        Deque<Node2> queue = new ArrayDeque<>();

        // 제일 먼저 방문해야 할 노드는 당연히 트리의 '뿌리(root)' 노드겠죠?
        // 그래서 루트 노드를 큐의 맨 뒤에 넣습니다. (대기열에 추가)
        queue.offer(root);

        // 현재 우리가 탐색하고 있는 '레벨(층)'을 나타내는 변수입니다.
        // 뿌리 노드가 있는 층은 '레벨 0'으로 시작합니다.
        int level = 0;

        // --- while 루프 설명 시작 ---
        // 'while(!queue.isEmpty())' : 큐가 비어있지 않은 동안 계속 반복합니다.
        // 즉, '더 이상 방문할 노드가 남아있지 않을 때까지' 계속 탐색을 진행한다는 뜻입니다.
        while(!queue.isEmpty()){
            // 'currentLevelSize' : 현재 큐에 몇 개의 노드가 들어있는지 (즉, 현재 층에 몇 개의 방이 있는지) 확인합니다.
            // 이 숫자는 현재 레벨에 있는 모든 노드를 처리하기 위해 매우 중요합니다.
            int currentLevelSize = queue.size();

            // 현재 우리가 몇 번째 층(레벨)을 탐색하고 있는지 화면에 출력합니다.
            System.out.print("Level " + level + ": ");

            // --- for 루프 설명 시작 ---
            // 'for (int i = 0; i < currentLevelSize; i++)' : 현재 층에 있는 모든 노드를 하나씩 방문합니다.
            // 'i'는 0부터 'currentLevelSize - 1'까지 증가하면서 반복됩니다.
            for (int i = 0; i < currentLevelSize; i++) {
                // 'currentNode = queue.poll()' : 큐의 맨 앞에 있는 노드를 하나 꺼냅니다. (대기열의 맨 앞 사람을 불러냄)
                // 이 'currentNode'가 현재 우리가 방문하고 있는 노드입니다.
                Node2 currentNode = queue.poll();

                // 현재 방문한 노드의 '데이터(값)'를 화면에 출력합니다.
                System.out.print(currentNode.data + " ");

                // --- 왼쪽 자식 처리 ---
                // 'if(currentNode.lt != null)' : 만약 현재 노드에 왼쪽 자식(방)이 있다면,
                if(currentNode.lt != null){
                    // 그 왼쪽 자식을 큐에 추가합니다. (다음 층을 탐색할 때 방문해야 하므로 대기열에 넣어둠)
                    queue.offer(currentNode.lt);
                }

                // --- 오른쪽 자식 처리 ---
                // 'if(currentNode.rt != null)' : 만약 현재 노드에 오른쪽 자식(방)이 있다면,
                if(currentNode.rt != null){
                    // 그 오른쪽 자식을 큐에 추가합니다. (다음 층을 탐색할 때 방문해야 하므로 대기열에 넣어둠)
                    queue.offer(currentNode.rt);
                }
            }
            // 현재 층(레벨)의 모든 노드들을 다 출력했으니, 다음 층의 출력을 위해 줄을 바꿉니다.
            System.out.println();

            // 현재 층의 탐색이 모두 끝났으니, 이제 다음 층으로 넘어갈 차례입니다.
            // 그래서 'level' 변수를 1 증가시킵니다. (레벨 0 -> 레벨 1 -> 레벨 2 ...)
            level++;
        }
        // --- while 루프 설명 끝 ---
    }
    // --- BFS 메서드 설명 끝 ---


    // --- main 메서드 설명 시작 ---
    // 이 메서드는 자바 프로그램이 시작될 때 가장 먼저 실행되는 부분입니다.
    public static void main(String[] args) {
        // 'Main7' 클래스의 객체를 하나 만듭니다. 이 객체를 통해 트리를 만들고 BFS 메서드를 호출할 거예요.
        Main7 tree = new Main7();

        // --- 트리 구성 시작 ---
        // 이제 Node2 객체들을 만들어서 트리를 구성해봅시다.
        // 먼저 트리의 가장 꼭대기(뿌리) 노드를 만듭니다. 값은 1입니다.
        // 현재 트리: (1)
        tree.root = new Node2(1);

        // 레벨 1의 노드들을 만들고, 루트 노드(1)의 왼쪽과 오른쪽에 연결합니다.
        // 현재 트리:
        //       (1)
        //      /   \
        //    (2)   (3)
        tree.root.lt = new Node2(2); // 노드 1의 왼쪽 자식으로 노드 2를 연결
        tree.root.rt = new Node2(3); // 노드 1의 오른쪽 자식으로 노드 3을 연결

        // 레벨 2의 노드들을 만들고, 레벨 1의 노드들(2, 3)의 자식으로 연결합니다.
        // 현재 트리:
        //       (1)
        //      /   \
        //    (2)   (3)
        //   / \   / \
        // (4) (5) (6) (7)
        tree.root.lt.lt = new Node2(4); // 노드 2의 왼쪽 자식으로 노드 4를 연결
        tree.root.lt.rt = new Node2(5); // 노드 2의 오른쪽 자식으로 노드 5를 연결
        tree.root.rt.lt = new Node2(6); // 노드 3의 왼쪽 자식으로 노드 6을 연결
        tree.root.rt.rt = new Node2(7); // 노드 3의 오른쪽 자식으로 노드 7을 연결
        // --- 트리 구성 끝 ---

        // 이제 구성된 트리에 대해 BFS 탐색을 시작합니다.
        // BFS 메서드를 호출하면서 트리의 뿌리 노드(tree.root)를 넘겨줍니다.
        tree.BFS(tree.root);
    }
}
// --- main 메서드 설명 끝 ---