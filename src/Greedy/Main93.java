import java.util.*;
// 그래프의 간선(Edge)을 표현하는 클래스
class Edge implements Comparable<Edge>{
    public int vex; // 간선이 연결되는 다음 정점(vertex)
    public int cost; // 해당 간선을 따라 이동하는 데 드는 비용(가중치)
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost - ob.cost; // 비용(cost)을 기준으로 오름차순 정렬
    }
}
public class Main {
    static int n; // 정점(vertex)의 개수
    static int m; // 간선(edge)의 개수다
    // 각 정점(인덱스)에 연결된 Edge 객체들의 리스트를 저장
    // 예: graph.get(1)은 1번 정점에서 나가는 모든 간선들을 담고 있다.
    static ArrayList<ArrayList<Edge>> graph;
    // answer[i]는 시작 정점(1번 정점)에서 i번 정점까지의 현재까지 발견된 최단 거리를 저장함
    static int[] answer;
    // solution 메소드는 다익스트라(Dijkstra) 알고리즘을 구현
    public void solution(int v){
        // PriorityQueue를 사용하여 방문할 정점들을 비용(cost) 기준으로 오름차순 정렬
        // 즉, 현재까지의 최단 거리가 가장 짧은 정점부터 처리
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));// 시작 정점(v)을 우선순위 큐에 넣는다. 시작 정점의 비용은 0
        answer[v] = 0; // 시작 정점의 최단 거리를 0으로 초기화
        while(!pQ.isEmpty()){  // (더 이상 방문할 정점이 없을 때까지 반복
            // 큐에서 현재까지의 비용이 가장 낮은 정점(Edge)을 꺼낸다.
            Edge tmp = pQ.poll();
            int now = tmp.vex;     // 현재 정점의 번호
            int nowCost = tmp.cost; // 시작 정점에서 현재 정점까지의 최단 거리
            // 만약 현재 꺼낸 정점의 비용(nowCost)이 이미 answer[now]에 저장된 최단 거리보다 크다면,
            // 이 경로는 최단 경로가 아니거나 이미 더 짧은 경로를 찾았다는 의미이므로 continue
            if(nowCost > answer[now]) continue;
            for(Edge ob : graph.get(now)){ // 현재 정점(now)과 연결된 모든 간선(Edge)들을 순회
                // 현재 정점(now)을 거쳐 다음 정점(ob.vex)으로 가는 비용 (nowCost + ob.cost)이
                // 이전에 answer[ob.vex]에 저장된 최단 거리보다 더 짧다면,
                if(answer[ob.vex] > nowCost + ob.cost){
                    // answer[ob.vex]를 새로운 최단 거리로 갱신
                    answer[ob.vex] = nowCost + ob.cost;
                    // 갱신된 최단 거리를 가진 다음 정점을 우선순위 큐에 추가
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }
    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // 정점(vertex)의 개수를 입력
        m = kb.nextInt(); // 간선(edge)의 개수를 입력
        // graph 인접 리스트를 n+1 크기로 초기화(1번 정점부터 N번 정점까지 사용)
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Edge>()); // 각 정점에 대한 빈 Edge 리스트를 추가
        }
        // answer 배열을 n+1 크기로 생성하고, 모든 원소를 Integer.MAX_VALUE로 초기화
        answer = new int[n + 1];
        Arrays.fill(answer, Integer.MAX_VALUE); // 모든 거리를 무한대로 설정
        // m개의 간선 정보를 입력받아 graph에 추가합니다.
        // (a -> b로 가는 비용이 c인 간선)
        for(int i = 0; i < m; i++){
            int a = kb.nextInt(); // 시작 정점
            int b = kb.nextInt(); // 도착 정점
            int c = kb.nextInt(); // 비용(가중치)
            graph.get(a).add(new Edge(b, c)); // a에서 b로 가는 간선을 추가
        }
        // solution 메소드를 호출하여 1번 정점에서 시작하는 최단 거리를 계산 시작
        T.solution(1);
        // 2번 정점부터 N번 정점까지의 최단 거리를 출력
        for(int i = 2; i <= n; i++){
            // 만약 answer[i]가 Integer.MAX_VALUE가 아니라면 (경로가 존재한다면)
            if(answer[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + answer[i]); // "정점번호 : 최단거리" 형식으로 출력
            }
            // 경로가 존재하지 않는다면 "정점번호 : impossible" 출력
            else {
                System.out.println(i + " : impossible");
            }
        }
        kb.close();
    }
}