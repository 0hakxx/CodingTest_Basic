package Greedy;
import java.util.*;

class Edge implements Comparable<Edge> {
    public int v;
    public int cost;
    public Edge(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

//다익스트라 알고리즘
public class Main93 {
    static int v; //정점의 개수
    static int n; //간선의 개수
    static int[] answer; // ex. 2번 인덱스에 간선 2까지 가는 최소 거리비용 저장
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();

    public void BFS(){

    }

    public static void main(String[] args) {
        Main93 T = new Main93();
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        n = sc.nextInt();
        answer = new int[v+1];
        for(int i=0; i<=v; i++){
            answer[i] = Integer.MAX_VALUE; //answer 배열에 모든 값을 최대치로 초기화
        }
        answer[1] = 0; //출발 정점은 0



    }
}