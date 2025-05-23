package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main4 {
    public int solution(String str) {
        int answer = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '('){
                stack.push(ch);
            }
            else { // ch == ')'
                stack.pop();
                if(str.charAt(i-1) == '(') { // 레이저
                    answer += stack.size();
                } else { // 쇠막대기 끝
                    answer += 1;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Main4 T = new Main4();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();



        System.out.println(T.solution(str));
    }
}
