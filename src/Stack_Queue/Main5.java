package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main5 {
    public int solution(int N, int K) {
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }


        int count = 0;
        while(queue.size() != 1){
            count++;
            if(count == K){
                queue.poll();
                count = 0;
            }else {
                queue.offer(queue.poll());
            }
        }

        return queue.peek();

    }

    public static void main(String[] args) {
        Main5 T = new Main5();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(T.solution(N,K));
    }
}
