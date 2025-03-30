package String;

import java.util.Scanner;


public class Main10 {
//10. 가장 짧은 문자거리
//    한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
//    첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
//    문자열의 길이는 100을 넘지 않는다.
//    첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
//
//
//    예시 입력 1 ： teachermode e
//    예시 출력 1 ： 1 0 1 2 1 0 1 2 2 1 0


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();       // 공백 전까지의 문자열 읽기
        char target = sc.next().charAt(0);  // 다음 토큰(문자) 읽기

        int[] answer = new int[str.length()];
        int p = 1000;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == target) {
                p = 0;
                answer[i] = p;
            }
            else {
                p++;
                answer[i] = p;
            }
        }

        for(int i = str.length()-1; i >= 0; i--) {
            if(str.charAt(i) == target) {
                p = 0;
                answer[i] = p;
            }
            else {
                p++;
                if(answer[i] > p) {
                    answer[i] = p;
                }
            }
        }


        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        return ;
    }
}

