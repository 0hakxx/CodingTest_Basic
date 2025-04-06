package Array;


import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.Scanner;

//1. 큰 수 출력하기
//설명 : N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요. (첫 번째 수는 무조건 출력한다)
//입력 : 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
//출력 : 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
//
//
//예시 입력 1
//        6
//        7 3 9 5 6 12
//
//예시 출력 1
//        7 9 6 12


//이 문제의 핵심은 ArrayList(동적 크기 배열)로 푸는 것이 코드 간편화할 수 있음.

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public ArrayList<Integer> solution(int[] array) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(array[0]); // Always include the first element

        for (int i = 1; i < array.length; i++) { // Start from second element
            if (array[i] > array[i - 1]) { // Compare with the previous element
                answer.add(array[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main1 T = new Main1();
        Scanner kb = new Scanner(System.in);
        int size = kb.nextInt();
        kb.nextLine(); // Consume newline
        String input = kb.nextLine();
        String[] parts = input.split(" ");

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        for (int x : T.solution(arr)) {
            System.out.print(x + " ");
        }
    }
}
