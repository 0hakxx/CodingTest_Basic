package Dynmaic;

import java.util.*;

// Dynamic Programming (동적 프로그래밍) 예제
// 이 기법은 큰 문제를 작은 문제로 나누고,
// 작은 문제들의 해결책을 저장해뒀다가 나중에 더 큰 문제를 풀 때 재사용하여 효율성을 높인다.

/*
   예시 (7번째 계단까지 가는 방법):

   문제를 작은 단위로 분할하여 생각해보면:
   - 1번째 계단에 가는 방법: 1가지 (1칸)
   - 2번째 계단에 가는 방법: 2가지 (1칸+1칸, 2칸)
   - 3번째 계단에 가는 방법:
     - 1번째 계단에서 2칸 점프
     - 2번째 계단에서 1칸 점프
     즉, 1가지 + 2가지 : 3가지이다.

   이 패턴은 피보나치 수열과 동일
*/

public class Main98 {
    static int[] dy; // 동적 프로그래밍을 위한 배열. dy[i]는 i번째 계단까지 가는 방법의 수를 저장
    public int solution(int n){
        dy[1] = 1; // 1번째 계단까지 가는 방법은 1가지 (1칸 오르기)
        dy[2] = 2;
        for(int i = 3; i <= n; i++){
            dy[i] = dy[i-1] + dy[i-2];
        }
        return dy[n];
    }
    public static void main(String[] args) {
        Main98 T = new Main98();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n++;
        dy = new int[n+1];

        System.out.println(T.solution(n));
        sc.close();
    }
}