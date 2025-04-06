package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Main7 {

    public int solution(int[] arr) {
        int total = 0;
        int plus = 0;
        for(int i = 1; i <= arr.length; i++) {
            if(arr[i-1] == 1){
                plus++;
            }
            else plus = 0;

            total = total + plus;
        }
        return total;
    }

    public static void main(String[] args) {
        Main7 T = new Main7(); // Main4 클래스의 인스턴스 생성
        Scanner kb = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        int size = kb.nextInt(); // 사용자로부터 배열 크기 입력받음
        int[] arr = new int[size+1];

        for(int i = 0; i < size; i++){
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
