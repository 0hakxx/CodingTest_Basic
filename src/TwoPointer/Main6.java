package TwoPointer;

import java.util.Scanner;


class Main6 {
    public int solution(int n, int[] arr, int k) {
        int answer = 0;
        int lt = 0;
        int cnt = 0; // 0을 1로 바꾼 횟수

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) cnt++;

            // 0을 바꾼 횟수가 k를 초과하면 윈도우 줄이기
            while (cnt > k) {
                if (arr[lt] == 0) cnt--;
                lt++;
            }

            // 최대 길이 갱신
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

    public static void main(String[] args){
        Main6 T = new Main6();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int k = kb.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = kb.nextInt();
        }

        // 결과 출력
        System.out.print(T.solution(n, arr, k));
    }
}
