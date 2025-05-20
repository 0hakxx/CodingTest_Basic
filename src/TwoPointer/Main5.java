package TwoPointer;

import java.util.Scanner;


class Main5 {
    public int solution(int n){
        int answer = 0;
        int m = n/2+1;
        int[] arr = new int[m];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }
        int sum=0;
        int lt=0;
        for(int rt=0; rt<arr.length; rt++){
            sum += arr[rt];

            if(sum==n){answer++;}

            while(sum >= n){
                sum -= arr[lt];
                lt++;
                if(sum==n){answer++;}
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main5 T = new Main5();
        Scanner kb = new Scanner(System.in);


        int n = kb.nextInt();
        // 결과 출력
        System.out.print(T.solution(n));
    }
}
