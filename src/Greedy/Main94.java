package Greedy;

//Union&Find 알고리즘(서로소 집합, 집합이 다르면 친구가 아닌 문제)
import java.util.*;
public class Main94 {
    // Ex. 인덱스 1에서 1번 사람의 집합 번호를 저장, 집합의 번호가 같을 경우 친구
    static int[] parent;

    public static int find(int person){ // 사람 번호가 들어오면, 그 사람의 집합의 번호를 반환하는 메서드
        if(person == parent[person]) return person;
        //else return find(parent[person]); //으로도 문제는 풀림, 그러나 저장하고 반환하면 경로 압축되어 성능 향상
        else return parent[person] = find(parent[person]); //경로 압축(핵심 로직)
    }
    public static void union(int person1, int person2){ // 사람1과 사람2를 친구로 합쳐주는 메서드
        int rootOfPerson1 = find(person1);
        int rootOfPerson2 = find(person2);
        if(rootOfPerson1 != rootOfPerson2) parent[rootOfPerson1] = rootOfPerson2;
    }
    public static void main(String[] args) {
        Main94 T = new Main94();
        Scanner sc = new Scanner(System.in);
        int numberOfPeople = sc.nextInt();    // 총 사람 수
        int numberOfRelations = sc.nextInt(); // 친구 관계 수
        parent = new int[numberOfPeople + 1];
        for (int i = 0; i <= numberOfPeople; i++) parent[i] = i; // 처음에는 집합의 번호를 사람 자신의 번호로 초기화

        for (int i=1; i<=numberOfRelations; i++){
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            union(p1, p2);
        }

        int queryPerson1 = sc.nextInt(); // 질의할 첫 번째 사람
        int queryPerson2 = sc.nextInt(); // 질의할 두 번째 사람

        int rootOfQueryPerson1 = find(queryPerson1);
        int rootOfQueryPerson2 = find(queryPerson2);

        //집합 번호가 같으면 친구 YES 출력 , 아니면 NO 출력
        if(rootOfQueryPerson1 == rootOfQueryPerson2) System.out.println("YES");
        else System.out.println("NO");
    }
}