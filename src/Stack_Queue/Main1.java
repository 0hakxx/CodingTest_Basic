package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main1 {
    public String solution(String str){
        Deque<Character> deque = new ArrayDeque<>();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                deque.push(str.charAt(i));
            }
            if(str.charAt(i) == ')'){
                if(deque.isEmpty()){
                    return "NO";
                }
                deque.pop();
            }
        }
        if(!deque.isEmpty()){
            return "NO";
        }

        return "YES";






    }

    public static void main(String[] args) {
        Main1 T = new Main1();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(T.solution(str));

    }
}
