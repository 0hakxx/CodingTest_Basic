package Greedy;

import java.util.*;
//트리는 정점 n개가 주어졌을 때 간선 n-1개인 자료구조이다. ==> 루프가 없다.
//최소 스패닝 트리 - 프림(riorityQueue 사용)
class Edge96 implements Comparable<Edge96> {
    int v;   //목적지 정점
    int cost;
    public Edge96(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge96 o) {
        return this.cost - o.cost; //비용 기준 오름차순 정렬
    }
}
public class Main96 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        // 방문한 정점인지 아닌지 확인하는 배열, 인덱스 번호 = 정점 번호
        // 0이면 방문 X, 1이면 방문 O
        int[] ch = new int[n+1];
        ArrayList<ArrayList<Edge96>> graph = new ArrayList<ArrayList<Edge96>>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Edge96>());
        }
        int m = sc.nextInt();
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            //무방향 그래프
            graph.get(a).add(new Edge96(b, cost)); // a 정점에서 b의 정점까지 가는 비용 c
            graph.get(b).add(new Edge96(a, cost)); // b 정점에서 a의 정점까지 가는 비용 c
        }
        PriorityQueue<Edge96> pq = new PriorityQueue<Edge96>(); // 최소 비용 기준으로 poll
        // 정점 1에서 시작
        pq.add(new Edge96(1,0));

        while(!pq.isEmpty()) {
            Edge96 tmp = pq.poll();
            int ev = tmp.v; // ev = 도착 정점(end vex)
            if(ch[ev]==0) { // 방문하지 않은 정점이라면
                ch[ev] = 1; // 방문 처리
                answer += tmp.cost;
                for(Edge96 ob : graph.get(ev)) {
                    // 방문하지 않은 정점만 큐에 추가
                    if(ch[ob.v]==0) {pq.offer(new Edge96(ob.v, ob.cost));}
                }
            }
        }
        System.out.println(answer);
    }
}