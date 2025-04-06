package Array;

import java.util.Scanner;

public class Main9 {

    public int solution(int size, int[][] arr) {
        int max = 0;
        int answer = 0;

        int sum1, sum2, sum3, sum4;
        for (int i = 0; i < size; i++) {
            sum1 = 0;
            for (int j = 0; j < size; j++) {
                sum1 += arr[i][j];
            }
            answer = Math.max(answer, sum1);
        }

        for (int i = 0; i < size; i++) {
            sum2 = 0;
            for (int j = 0; j < size; j++) {
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum2);
        }

        sum3 = 0;
        for (int i = 0; i < size; i++) {
            sum3 += arr[i][i];
            answer = Math.max(answer, sum3);
        }

        sum4 = 0;
        for (int i = 0; i < size; i++) {
            sum4 += arr[i][size-i-1];
            answer = Math.max(answer, sum4);
        }
        return answer;
    }


    public static void main(String[] args) {
        Main9 T = new Main9(); // Main4 클래스의 인스턴스 생성
        Scanner kb = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        int size = kb.nextInt(); // 사용자로부터 배열 크기 입력받음
        int[][] arr = new int[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(size, arr));
    }
}
