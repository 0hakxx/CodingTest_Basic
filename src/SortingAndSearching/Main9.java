package SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class Main9 {

    // mid 거리로 c마리의 말을 배치할 수 있는지 확인하는 함수
    public boolean check(int c, int mid, int[] arr){
        int count = 1; // 첫 번째 말은 항상 arr[0]에 배치했으므로 count는 1로 시작
        int ep = arr[0]; // 바로 전에 배치한 말의 위치

        for(int i = 1; i < arr.length; i++){ // 두 번째 마구간부터 순회
            if(arr[i] - ep >= mid){ // 현재 마구간과 직전 마구간의 거리가 mid 이상이면
                ep = arr[i]; // 현재 마구간에 말을 배치
                count++;     // 배치한 말의 수 증가
            }
        }
        // 배치 가능한 말의 수가 c보다 크거나 같으면, mid 거리는 유효하다.
        return count >= c;
    }


    public int solution(int n, int c, int[] arr) {
        int answer = 0;

        // 배열은 이미 main에서 Arrays.sort(arr)로 정렬되어 있음

                // 이분 탐색의 범위 설정
                // lt: 가능한 최소 거리 (최소 1)
                // rt: 가능한 최대 거리 (가장 먼 두 마구간의 거리)
                int lt = 1;
                int rt = arr[n-1] - arr[0];

                while(lt <= rt) {
                    int mid = (lt + rt) / 2; // 중간 거리
                    if(check(c, mid, arr)) { // mid 거리가 가능하면
                        answer = mid;   // 현재 mid가 가능한 최대 거리 후보
                        lt = mid + 1;   // 더 큰 거리도 가능한지 탐색 (최대 거리 찾기)
            } else { // mid 거리가 불가능하면
                rt = mid - 1;   // mid를 줄여서 다시 탐색
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main9 T = new Main9();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 마구간의 개수
        int c = kb.nextInt(); // 말의 마리 수

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt(); // 마구간의 좌표 입력
        }

        Arrays.sort(arr); // 마구간 좌표를 오름차순으로 정렬

        System.out.print(T.solution(n, c, arr));

        kb.close(); // Scanner 닫기
    }
}