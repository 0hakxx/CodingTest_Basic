package Greedy;

//Union&Find 알고리즘
import java.util.*;
public class Main94 {
    static int[] unf; //1번 학생(인덱스 : 1)의 값은 집합의 번호를 저장, 집합의 번호가 같을 경우 친구

    public static int find(int student){ //학생 번호가 들어오면, 그 학생의 집합의 번호를 반환
        if(student == unf[student]) return unf[student];
        else return unf[student] = find(unf[student]); //자기 자신 호출, 핵심 로직
    }

    public static void union(int student1, int student2){ //학생1과 학생2 를 친구로 합쳐주는 메서드
        int find_stu1 = find(student1);
        int find_stu2 = find(student2);
        if(find_stu1 != find_stu2) unf[find_stu1] = find_stu2;
    }
    public static void main(String[] args) {
        Main94 T = new Main94();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];
        for (int i = 0; i<=n; i++) unf[i] = i; // 처음에는 집합의 번호를 학생 자신의 번호로 초기화
        for (int i=1; i<=m; i++){
            int student1 = sc.nextInt();
            int student2 = sc.nextInt();
            union(student1,student2);
        }
        int student1 = sc.nextInt();
        int student2 = sc.nextInt();
        int find_stu1 = find(student1);
        int find_stu2 = find(student2);
        if(find_stu1 == find_stu2) System.out.println("YES");
        else System.out.println("NO");
    }
}