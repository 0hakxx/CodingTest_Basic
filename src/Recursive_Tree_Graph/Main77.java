import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


class Main77 {
    static int n; // 동전 종류의 개수
    static int total_coin; // 만들어야 할 목표 금액
    static Integer coin[]; // 주어진 동전들의 '값' 배열 (내림차순 정렬을 위해 Integer[] 사용)
    static int answer = Integer.MAX_VALUE; // 목표 금액을 만드는 '최소 동전 개수'를 저장 (초기값: 가능한 가장 큰 정수)

    
    public void DFS(int L, int sum) {
        // 1. 가지치기 (Pruning) - 효율성 극대화!
        // 현재까지의 금액이 목표 금액을 초과하면, 더 이상 탐색할 필요 없음 (무의미한 경로)
        if(sum > total_coin) return;
        // 현재 사용한 동전 개수가 이미 찾은 최소 개수(answer)보다 크거나 같으면,
        // 더 최적의 해를 찾을 가능성이 없으므로 탐색 중단 (매우 중요!)
        if(L >= answer) return;

        // 2. 종료 조건 (Base Case) - 목표 달성!
        // 현재까지의 금액이 목표 금액과 정확히 일치하면, 유효한 경로를 찾은 것
        if(sum == total_coin) {
            // 현재 동전 개수(L)와 기존의 최소 개수(answer) 중 더 작은 값으로 answer 갱신
            answer = Math.min(answer, L);
            // 목표를 달성했으니, 이 경로의 더 깊은 탐색은 무의미하므로 즉시 종료
            return; 
        }
        // 3. 재귀 호출 (Recursive Step) - 다음 동전 선택
        // sum < total_coin 일 경우:
        else{
            for(int i=0; i<n; i++){
                // 'coin[i]' 동전을 사용하는 경우의 재귀 호출
                // 동전 개수(L) 1 증가, 금액(sum)에 coin[i] 값 추가
                DFS(L+1, sum+coin[i]);
            }
        }
    }


    public static void main(String[] args) {
        Main77 T = new Main77();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 동전 종류의 개수 입력
        coin = new Integer[n]; // 동전 값을 저장할 배열 초기화

        // 동전 값들을 입력받아 배열에 저장
        for(int i=0; i<n; i++){
            coin[i] = sc.nextInt();
        }
        total_coin = sc.nextInt(); // 목표 금액 입력

        // *************** 중요 최적화: 동전 배열 내림차순 정렬 ***************
        // 큰 동전부터 먼저 사용하도록 정렬하면, 목표 금액에 더 빨리 도달할 가능성이 높아짐
        // -> 'L >= answer' 가지치기가 더 일찍 발동하여 전체 탐색 시간 단축에 기여
        // 실제 문제 풀이 시 내림차순 정렬 안 하면 시간 초과 발생함
        Arrays.sort(coin, Collections.reverseOrder());

        // DFS 탐색 시작
        // 초기 호출: 사용한 동전 0개, 현재 금액 0부터 시작
        T.DFS(0, 0);

        System.out.println(answer);

        sc.close();
    }
}