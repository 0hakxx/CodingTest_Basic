package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main3 {
    public int solution(String str) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch >= '1' &&  ch <= '9') {
                stack.push(ch - '0');
            }
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(ch == '+'){
                    stack.push(lt + rt);
                }
                else if(ch == '-'){
                    stack.push(lt - rt);
                }
                else if(ch == '*'){
                    stack.push(lt * rt);
                }
                else if(ch == '/'){
                    stack.push(lt / rt);
                }
            }
        }
        return stack.peek();

    }

    public static void main(String[] args) {
        Main3 T = new Main3();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();



        System.out.println(T.solution(str));
    }
}
