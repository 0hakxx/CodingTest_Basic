package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Main6 {

    public boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i =2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public ArrayList<Integer> solution(int size, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i = 0; i < size; i++){
            int temp = arr[i];
            int res = 0;
            while(temp > 0){
                int t = temp % 10;
                res = res * 10 + t;
                temp = temp / 10;
            }
            if(isPrime(res)){
                answer.add(res);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main6 T = new Main6(); // Main4 클래스의 인스턴스 생성
        Scanner kb = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        int size = kb.nextInt(); // 사용자로부터 배열 크기 입력받음
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = kb.nextInt();
        }
        for (int i : T.solution(size, arr)) {
            System.out.print(i+" ");
        }
    }
}
