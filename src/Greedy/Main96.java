package Greedy;

import java.util.*;
//트리는 정점 n개가 주어졌을 때 간선 n-1개인 자료구조이다. ==> 루프가 없다.
//크루스칼 알고리즘(Union & Find)
class Edge96 implements Comparable<Edge96> {
    int v1;   //시작 정점
    int v2;   //목적지 종점
    int cost; //가중치
    public Edge96(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge96 o) {
        return this.cost - o.cost; //비용 기준 오름차순 정렬
    }
}
public class Main96 {
    static int[] unf;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //입력받는 정점 개수
        unf = new int[n +1];
        int m = sc.nextInt(); //입력받는 간선 개수
        ArrayList<Edge96> edges = new ArrayList<Edge96>();
        for(int i = 0; i < m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge96(v1, v2, cost));
        }
        for (int i = 0; i <= n; i++) unf[i] = i; // 처음에는 집합의 번호를 정점 자신의 번호로 초기화
        int answer = 0;
        Collections.sort(edges); //비용 기준 오름차순 정렬

        System.out.println(answer);
    }
}