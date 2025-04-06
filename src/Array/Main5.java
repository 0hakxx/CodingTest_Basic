package Array;

import java.util.Scanner;

public class Main5 {

    public int solution(int size) {
        int count = 0;
        int[] answer = new int[size+1];
        for (int i = 2; i <= size; i++) {
            if(answer[i] == 0){count++;}
            for(int j=i; j <= size; j = j + i){answer[j] = 1;}
        }
        return count;
    }

    public static void main(String[] args) {
        Main5 T = new Main5(); // Main4 클래스의 인스턴스 생성
        Scanner kb = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        int size = kb.nextInt(); // 사용자로부터 배열 크기 입력받음


        System.out.println(T.solution(size));
    }
}
