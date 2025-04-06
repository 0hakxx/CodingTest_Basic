package Array;

import java.util.Scanner;

public class Main4 {
    // 피보나치 수열을 생성하는 메서드
    public int[] solution(int size) {
        // 크기가 size인 배열 생성
        int answer[] = new int[size];
        // 피보나치 수열의 첫 번째와 두 번째 값은 항상 1
        answer[0] = 1;
        answer[1] = 1;
        // 반복문을 통해 피보나치 수열 계산 (현재 값 = 이전 값 + 그 이전 값)
        for (int i = 2; i < size; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }
        // 계산된 피보나치 수열 배열 반환
        return answer;
    }

    public static void main(String[] args) {
        Main4 T = new Main4(); // Main4 클래스의 인스턴스 생성
        Scanner kb = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        int size = kb.nextInt(); // 사용자로부터 배열 크기 입력받음


        // solution 메서드를 호출해서 피보나치 수열 배열을 반환받고 출력
        for (int i : T.solution(size)) {
            System.out.print(i + " "); // 배열의 각 값을 공백으로 구분해서 출력
        }
    }
}
