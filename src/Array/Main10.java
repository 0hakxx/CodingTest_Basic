package Array;

import java.util.Scanner;

public class Main10 {

    public int solution(int size, int[][] arr) {
        int count = 0;
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                if(  (arr[i][j]  > arr[i-1][j]) && (arr[i][j] > arr[i][j-1]) && (arr[i][j] > arr[i][j+1] && (arr[i][j] > arr[i+1][j])) ){
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Main10 T = new Main10(); // Main4 클래스의 인스턴스 생성
        Scanner kb = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        int size = kb.nextInt(); // 사용자로부터 배열 크기 입력받음
        int[][] arr = new int[size+2][size+2];

        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(T.solution(size,arr));
    }
}
