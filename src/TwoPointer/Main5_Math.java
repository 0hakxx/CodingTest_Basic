package TwoPointer;

import java.util.Scanner;


class Main5_Math {
    public int solution(int n){
        int answer=0, cnt=1;
        n--;
        while(n>0){
            cnt++;
            n=n-cnt;
            if(n%cnt==0) answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        Main5_Math T = new Main5_Math();
        Scanner kb = new Scanner(System.in);


        int n = kb.nextInt();
        // 결과 출력
        System.out.print(T.solution(n));
    }
}
