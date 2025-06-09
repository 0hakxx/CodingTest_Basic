package Greedy;
import java.util.*;

class Edge implements Comparable<Edge> {
    public int vex;  //정점 번호
    public int cost; //가중치(비용)
    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost; //가중치 비용을 기준으로 오름차순 정렬
    }
}
public class Main93 {
    static int n; //전체 정점의 개수
    static int m; //간선의 개수
    // answer 배열: 각 정점(인덱스)까지 도달하는 데 필요한 최소 비용(거리)을 저장
    // Ex. answer[2]는 2번 정점까지의 최소 비용 저장
    static int[] answer;
    // graph.get(i)는 i번 정점에서 출발하는 모든 간선(Edge 객체)들을 담고 있는 ArrayList
    static ArrayList<ArrayList<Edge>> graph;
    // 다익스트라 알고리즘의 핵심 로직을 담고 있는 메서드
    public void solution(){
        // pQ는 Edge 클래스의 compareTo 메서드를 기반으로 cost가 가장 작은 Edge를 먼저 꺼낼 수 있도록 한다.
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        //시작 정점 관련 초기화
        pQ.offer(new Edge(1,0)); // 출발 정점(1,0)을 pQ에 추가하여 초기화
        answer[1] = 0; // 출발 최소 거리 비용은 0으로 초기화
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();   // 우선순위 큐에서 가장 비용이 작은 Edge 객체를 꺼낸다.
            int now = tmp.vex;      //현재 정점
            int nowCost = tmp.cost; //현재 비용
            if(nowCost > answer[now]){continue;} //이미 더 작은 값을 구했다면 continue
            for(Edge e : graph.get(now)){ //현재 정점에서 갈 수 있는 간선들을 탐색
                // 현재 정점까지의 비용(nowCost) + 현재 정점에서 인접 정점으로 가는 비용(e.cost)이
                // 기존에 인접 정점(e.vex)까지 저장된 최소 비용(answer[e.vex])보다 작다면,
                // 더 효율적인 경로를 찾았으므로 최소 비용을 갱신
                if(answer[e.vex] > nowCost+e.cost){
                    answer[e.vex] = nowCost+e.cost;
                    pQ.offer(new Edge(e.vex, nowCost+e.cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        Main93 T = new Main93();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answer = new int[n+1];
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        Arrays.fill(answer, Integer.MAX_VALUE); // answer 배열의 각 인덱스값을 MAX로 초기화
        for(int i=0; i<m; i++){
            int a = sc.nextInt(); //출발 정점
            int b = sc.nextInt(); //목적지 정점
            int c = sc.nextInt(); //가중치(비용)
            graph.get(a).add(new Edge(b, c));
        }
        T.solution();
        for(int i=2; i<=n; i++){ // 2번 정점부터 마지막 정점(n)까지의 최소 비용을 출력
            if(answer[i] != Integer.MAX_VALUE){System.out.println(i + " : " + answer[i]);} //MAX_VALUE가 아니라면 최소값을 구했으므로 출력
            else System.out.println(i + " : impossible");
        }
    }
}