package Recursive_Tree_Graph;

import java.util.*; // 자바 유틸리티 패키지(ArrayList, LinkedList, Queue, Scanner 등)를 모두 임포트합니다.


class Main13 {
    // static 변수들은 프로그램이 시작될 때 메모리에 한 번만 할당되며, 모든 메소드에서 공유됩니다.
    static int n, m, answer = 0; // n: 노드(정점)의 총 개수, m: 간선(엣지)의 총 개수
    // answer: 이 문제에서는 사용되지 않는 변수입니다. (이전 DFS 문제에서 남아있는 듯)

    static ArrayList<ArrayList<Integer>> graph; // 그래프의 연결 상태를 나타내는 인접 리스트 (Adjacency List)
    // graph.get(i)는 i번 노드에서 직접 갈 수 있는 모든 노드들의 리스트를 저장합니다.
    // 각 노드 i에 대해, 그 노드에서 직접 연결된(갈 수 있는) 다른 노드들의 목록을 담는 리스트입니다.
	/*
	   예시: n=5, 간선: 1->2, 1->3, 2->4, 3->4, 4->5 일 경우
	   graph 구조:
	   graph[0]: [] (인덱스 0은 사용 안 함)
	   graph[1]: [2, 3]  <-- 1번 노드에서 2, 3번 노드로 갈 수 있음
	   graph[2]: [4]     <-- 2번 노드에서 4번 노드로 갈 수 있음
	   graph[3]: [4]     <-- 3번 노드에서 4번 노드로 갈 수 있음
	   graph[4]: [5]     <-- 4번 노드에서 5번 노드로 갈 수 있음
	   graph[5]: []
	*/

    static int[] ch;      // 방문 여부를 체크하는 배열 (Visited Array)
    // ch[i] = 1 이면 i번 노드를 BFS 탐색 중 방문했음을 의미합니다.
    // ch[i] = 0 이면 i번 노드를 아직 방문하지 않았음을 의미합니다.
    // 이는 BFS가 무한 루프(사이클)에 빠지는 것을 방지하고, 최단 거리를 올바르게 찾도록 합니다.
	/*
	   ch 배열 초기 상태 (모두 0):
	   노드:   0  1  2  3  4  5 ... n
	   ch[]: [0][0][0][0][0][0]
	*/

    static int[] dis;     // 각 노드까지의 최단 거리(레벨)를 저장하는 배열 (Distance Array)
    // dis[i]는 시작 노드(여기서는 1번 노드)에서 i번 노드까지 도달하는 데 필요한 최소 간선 수를 저장합니다.
    // BFS는 '레벨' 단위로 탐색하기 때문에, 이 배열에 저장되는 값은 항상 최단 거리가 됩니다.
	/*
	   dis 배열 초기 상태 (모두 0):
	   노드:   0  1  2  3  4  5 ... n
	   dis[]:[0][0][0][0][0][0]
	*/

    // BFS (Breadth-First Search) 메소드
    // v: 탐색을 시작할 시작 노드의 번호
    public void BFS(int v){
        ch[v] = 1;
        dis[v] = 0;

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while(!queue.isEmpty()){
            int cv = queue.poll();

            for(int nv : graph.get(cv)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

    public static void main(String[] args){
        Main13 T = new Main13(); // Main 클래스의 인스턴스를 생성합니다. (BFS 메소드를 호출하기 위함)
        Scanner kb = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체를 생성합니다.

        n = kb.nextInt(); // 첫 번째 정수를 읽어 노드의 개수(n)로 설정합니다. (예: n = 5)
        m = kb.nextInt(); // 두 번째 정수를 읽어 간선의 개수(m)로 설정합니다. (예: m = 6)

        // 인접 리스트 'graph'를 초기화합니다.
        // 노드 번호가 1부터 n까지 사용되므로, n+1 크기의 ArrayList를 생성합니다.
        // graph.get(0)은 사용하지 않으므로 비워둡니다.
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>()); // 각 인덱스(노드 번호)에 해당하는 빈 ArrayList를 추가
        }

        // 방문 체크 배열 'ch'를 초기화합니다.
        // 노드 번호가 1부터 n까지 사용되므로, n+1 크기의 배열을 생성합니다. (인덱스 0은 사용 안 함)
        // 자바에서 int 배열은 기본적으로 0으로 초기화됩니다. (모든 노드 미방문 상태)
        ch = new int[n+1];

        // 거리 저장 배열 'dis'를 초기화합니다.
        // 노드 번호가 1부터 n까지 사용되므로, n+1 크기의 배열을 생성합니다. (인덱스 0은 사용 안 함)
        // 자바에서 int 배열은 기본적으로 0으로 초기화됩니다. (모든 노드까지의 초기 거리는 알 수 없음/무한대로 간주)
        dis = new int[n+1];

        // m개의 간선 정보를 입력받아 인접 리스트에 추가합니다.
        // graph.get(a).add(b)는 a번 노드에서 b번 노드로 가는 단방향 간선이 있음을 의미합니다.
        // 예시 간선 입력:
        // 1 2  (1에서 2로)
        // 1 3  (1에서 3로)
        // 2 4  (2에서 4로)
        // 3 4  (3에서 4로)
        // 4 5  (4에서 5로)
        // 1 5  (1에서 5로)
        for(int i = 0; i < m; i++){
            int a = kb.nextInt(); // 간선의 시작 노드
            int b = kb.nextInt(); // 간선의 끝 노드
            graph.get(a).add(b);  // a번 리스트에 b를 추가 (a에서 b로 갈 수 있음을 표시)
        }
        /*
        // 위 예시 간선 입력 후 graph의 모습:
        graph[1] = [2, 3, 5] // 1번 노드에서 갈 수 있는 곳은 2, 3, 5
        graph[2] = [4]
        graph[3] = [4]
        graph[4] = [5]
        graph[5] = []
        */

        // 1번 노드에서 BFS 탐색을 시작합니다.
        // BFS가 시작되면 ch 배열과 dis 배열이 시작 노드 1로부터의 최단 거리로 채워지게 됩니다.
        T.BFS(1);

        // BFS 탐색이 완료된 후, 2번 노드부터 n번 노드까지의 최단 거리를 출력합니다.
        // (1번 노드는 시작점이므로 거리가 0이어서 보통 출력 대상에서 제외하거나, 1번도 포함하여 출력할 수 있습니다.)
        for(int i = 2; i <= n; i++){
            System.out.println(i + " : " + dis[i]); // "노드번호 : 거리" 형식으로 출력
        }

        kb.close(); // Scanner 객체를 닫아 자원을 해제합니다.
    }
}