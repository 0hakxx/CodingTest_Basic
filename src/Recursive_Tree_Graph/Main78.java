package Recursive_Tree_Graph;
import com.sun.tools.javac.Main;

import java.util.Scanner;


class Main78 {

    static int[] currentPermutation; // 현재 만들고 있는 순열의 각 자리 값을 저장
    static boolean[] isUsed;         // 원본 숫자 배열에서 각 숫자의 사용 여부를 체크
    static int[] inputNumbers;       // 사용자로부터 입력받은 원본 숫자 배열

    static int numberOfElements;     // 원본 숫자 배열의 크기
    static int permutationLength;    // 만들 순열의 길이


    public void DFS(int level) {
        if(level == permutationLength) {
            for(int x : currentPermutation) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else{
            for(int i = 0; i < numberOfElements; i++) {
             if(isUsed[i] == false) {
                 isUsed[i] = true;
                 currentPermutation[level] = inputNumbers[i];
                 DFS(level + 1);
                 isUsed[i] = false;
             }
            }
        }

    }


    public static void main(String[] args) {
        Main78 solver = new Main78();
        Scanner scanner = new Scanner(System.in);

        // 1. 입력 받기
        numberOfElements = scanner.nextInt();   // 원본 숫자의 개수 (예: 3)
        permutationLength = scanner.nextInt();  // 만들 순열의 길이 (예: 2)

        // 2. 배열 초기화
        inputNumbers = new int[numberOfElements]; // 원본 숫자들을 저장할 배열
        for (int i = 0; i < numberOfElements; i++) {
            inputNumbers[i] = scanner.nextInt();
        }

        currentPermutation = new int[permutationLength]; // 만들어질 순열을 저장할 배열
        isUsed = new boolean[numberOfElements];          // 각 숫자의 사용 여부를 체크할 배열 (boolean은 기본값 false)

        // 3. 순열 생성 시작 (level 0부터)
        solver.DFS(0);

        scanner.close(); // 입력 스트림 닫기
    }
}