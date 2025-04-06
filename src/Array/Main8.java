package Array;

import java.util.Scanner;

public class Main8 {

    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length];


        for(int i = 0; i <arr.length; i++){
            int count = 1; //등수를 나타내는 변수
            for(int j = 0; j < arr.length; j++){
                if(arr[i] < arr[j]){
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main8 T = new Main8(); // Main4 클래스의 인스턴스 생성
        Scanner kb = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        int size = kb.nextInt(); // 사용자로부터 배열 크기 입력받음
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = kb.nextInt();
        }
        for (int i : T.solution(arr)) {
            System.out.print(i + " ");
        }
    }
}
