package Greedy;
import java.util.*;
//트리는 정점 n개가 주어졌을 때 간선 n-1개인 자료구조이다. 루프가 없다.
//크루스칼 알고리즘(Union & Find)
class Edge95 implements Comparable<Edge96> {
    int v1;   //시작 정점
    int v2;   //목적지 종점
    int cost; //가중치
    public Edge95(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge96 o) {
        return this.cost - o.cost; //비용 기준 오름차순 정렬
    }
}
public class Main95 {
    static ArrayList<Edge96> edges = new ArrayList<Edge96>();
    static int n; //입력받는 정점 개수
    static int m; //입력받는 간선 개수
    static int[] parent;
    public static int find(int v){ // 정점 번호가 들어오면, 그 정점의 집합의 번호를 반환하는 메서드
        if(v == parent[v]) return v;
            //else return find(parent[v]); //으로도 가능하지만 아래 코드로 최적화
        else return parent[v] = find(parent[v]); //경로 압축(핵심 로직)
    }
    public static void union(int v1, int v2){ // 정점1과 정점2를 같은 집합으로 만들어주는 메서드
        int rootV1 = find(v1);
        int rootV2 = find(v2);
        if(rootV1 != rootV2) parent[rootV1] = rootV2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        parent = new int[n +1];
        m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge96(v1, v2, cost));
        }
        for (int i = 0; i <= n; i++) parent[i] = i; // 처음에는 집합의 번호를 정점 자신의 번호로 초기화

        int answer = 0;
        Collections.sort(edges); //비용 기준 오름차순 정렬
        for(Edge96 e : edges){
            if(find(e.v1) != find(e.v2)){ //회로가 아닐 경우,
                union(e.v1, e.v2);
                answer += e.cost;
            }
        }
        System.out.println(answer);
    }
}