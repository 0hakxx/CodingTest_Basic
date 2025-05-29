package Recursive_Tree_Graph;
import java.util.*;

class Main80 {
    static int n;
    static int f;
    static int[] b; // 이항 계수 (n-1 C i)
    static int[] answer; // 순열
    static boolean[] check; // 방문 여부 체크
    static boolean flag = false; // 정답을 찾았는지 여부

    // 이항 계수 계산 (nCr)
    public static int comb(int n, int r){
        if(n==r || r == 0)
            return 1;
        else{
            return comb(n-1, r-1) + comb(n-1, r);
        }
    }

    // 깊이 우선 탐색 (DFS)
    public static void DFS(int level, int sum){
        // 이미 정답을 찾았으면 더 이상 탐색하지 않음
        if(flag){
            return;
        }

        // 모든 숫자를 선택했을 경우
        if(level == n){
            // 현재까지의 합이 목표값과 같으면
            if(sum == f){
                // 결과 출력
                for(int x : answer){
                    System.out.print(x + " ");
                }
                flag = true; // 정답을 찾았음을 표시
            }
            return; // 현재 경로 탐색 종료
        }
        else{
            // 1부터 n까지의 숫자 중 선택
            for(int i=1; i<=n; i++){
                // 이미 사용한 숫자인지 확인
                if(!check[i]){
                    check[i] = true; // 사용했다고 표시
                    answer[level] = i; // 현재 레벨에 숫자 할당
                    // 다음 레벨로 재귀 호출, sum에 현재 항을 더함
                    DFS(level+1, sum + b[level] * answer[level]);
                    check[i] = false; // 백트래킹: 사용하지 않았다고 표시
                }
            }
        }
    }

    public static void main(String[] args) {
        Main80 T = new Main80();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 숫자의 개수
        f = sc.nextInt(); // 목표 합

        b = new int[n]; // 이항 계수를 저장할 배열
        check = new boolean[n+1]; // 1부터 n까지의 숫자 사용 여부 체크
        answer = new int[n]; // 선택된 숫자 순열

        // b 배열에 이항 계수 저장 (n-1 C i)
        for(int i=0; i<n; i++){
            b[i] = comb(n-1, i);
        }

        // DFS 시작
        DFS(0, 0);
        sc.close();
    }
}