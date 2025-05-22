package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main2 {
    public int solution(int [][] board, int[] moves) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer=0;

        for(int pos : moves) {
            for(int i=0; i<board.length; i++){
                if (board[i][pos - 1] != 0) {
                    int temp = board[i][pos - 1];

                    if (stack.isEmpty() || stack.peek() != temp) {
                        stack.push(temp);
                    } else {
                        stack.pop();
                        answer += 2;
                    }
                    board[i][pos - 1] = 0;  // 공통된 처리
                    break;
                }}}
        return answer;

    }

    public static void main(String[] args) {
        Main2 T = new Main2();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] board = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                board[i][j] = sc.nextInt();
            }
        }
        int M = sc.nextInt();
        int [] moves = new int[M];
        for(int i=0;i<M;i++){
            moves[i] = sc.nextInt();
        }

        System.out.println(T.solution(board, moves));
    }
}
