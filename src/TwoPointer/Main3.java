package TwoPointer;

import java.util.*;

class Main3 {
    // n: 배열의 크기, k: 연속 부분 배열의 길이, arr: 입력 배열
    public int solution(int n, int k, int[] arr){
        int answer, sum=0;

        // 1. 처음 k개의 원소의 합을 구함 (첫 번째 윈도우의 합)
        // 예시: arr = [3, 2, 5, 6, 1], k = 3
        // 첫 윈도우: [3, 2, 5] -> sum = 10
        //   ↓↓↓
        // [3][2][5] 6 1
        for(int i=0; i<k; i++) sum+=arr[i];
        answer=sum; // answer를 첫 번째 윈도우의 합으로 초기화

        // 2. 슬라이딩 윈도우 기법을 사용하여, 다음 윈도우로 이동하면서 최대 합을 구함
        // 윈도우를 오른쪽으로 한 칸 이동할 때마다,
        // 맨 앞 원소는 빼고, 새로 들어온 원소는 더함
        //
        // 2번째 윈도우: [2, 5, 6] -> sum = 2+5+6 = 13
        //      ↓↓↓
        //  3 [2][5][6] 1
        //
        // 3번째 윈도우: [5, 6, 1] -> sum = 5+6+1 = 12
        //         ↓↓↓
        //  3 2 [5][6][1]
        for(int i=k; i<n; i++){
            // sum에서 arr[i-k]는 윈도우에서 빠지는 값, arr[i]는 새로 들어오는 값
            sum += (arr[i] - arr[i-k]);
            // answer에 현재까지의 최대 합을 저장
            answer = Math.max(answer, sum);
        }
        return answer; // 최대 합 반환
    }

    public static void main(String[] args){
        Main3 T = new Main3();
        Scanner kb = new Scanner(System.in);

        // 입력: n(배열 크기), k(부분 배열 길이)
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];

        // 배열 원소 입력
        for(int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }

        // solution 메서드 호출 후 결과 출력
        System.out.print(T.solution(n, k, arr));
    }
}
