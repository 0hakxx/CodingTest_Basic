package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main6 {
    public String solution(String str1, String str2) {
        String answer = "YES";

        Deque<Character> queue = new ArrayDeque<>();

        for(char ch : str1.toCharArray()) {
            queue.offer(ch);
        }
        for(char ch : str2.toCharArray()) {
            if(queue.contains(ch)) {
                if(queue.poll() == ch) {
                    continue;
                }
                else{
                    return "NO";
                }
            }
        }
        if (!queue.isEmpty()) return "NO";
        return answer;
    }


    public static void main(String[] args) {
        Main6 T = new Main6();

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(T.solution(str1, str2));
    }
}
