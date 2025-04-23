package TwoPointer;

import com.sun.tools.javac.Main;

import java.util.Scanner;


class Main4 {
    // 연속된 부분수열의 합이 m이 되는 경우의 수를 구하는 메소드
    public int solution(int n, int m, int[] arr){
        int answer = 0; // 정답(경우의 수) 저장
        int sum = 0;    // 현재 부분수열의 합
        int lt = 0;     // 왼쪽 포인터(부분수열의 시작 인덱스)

        // rt는 오른쪽 포인터(부분수열의 끝 인덱스)
        for(int rt = 0; rt < n; rt++){
            sum += arr[rt]; // 부분수열에 arr[rt]를 추가

            // 부분수열의 합이 m과 같으면 경우의 수 증가
            if(sum == m) answer++;

            // 부분수열의 합이 m 이상인 경우, lt를 이동시키며 합을 줄임
            while(sum >= m){
                sum -= arr[lt++]; // arr[lt]를 부분수열에서 제거하고 lt 증가
                // 부분수열의 합이 m과 같으면 경우의 수 증가
                if(sum == m) answer++;
            }
        }
        return answer; // 최종 경우의 수 반환
    }

    public static void main(String[] args){
        Main4 T = new Main4();
        Scanner kb = new Scanner(System.in);

        // 입력: 배열의 크기 n, 목표 합 m
        int n = kb.nextInt();
        int m = kb.nextInt();

        // 입력: n개의 배열 원소
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }

        // 결과 출력
        System.out.print(T.solution(n, m, arr));
    }
}
