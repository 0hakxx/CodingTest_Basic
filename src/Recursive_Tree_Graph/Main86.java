package Recursive_Tree_Graph; // 'Recursive_Tree_Graph' 패키지에 속하는 클래스임을 나타냅니다.

import java.util.ArrayDeque; // 큐(Queue) 인터페이스를 구현하는 클래스 중 하나로, 양방향 큐(Deque) 역할도 가능합니다. BFS에 큐로 사용됩니다.
import java.util.Deque;     // 큐와 스택의 기능을 모두 제공하는 인터페이스입니다. 여기서는 큐의 기능을 사용합니다.
import java.util.Scanner;   // 사용자로부터 입력을 받기 위해 Scanner 클래스를 임포트합니다.


class Point86{
    int x;
    int y;
    Point86(int x, int y){
        this.x = x;
        this.y = y;
    }
}


class Main86 {
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,-1,1,-1,1,-1,1};

    static int answer;
    static int N;

    static Deque<Point86> Q = new ArrayDeque<>();


    public void BFS(int x, int y, int[][] board) {
        // BFS 탐색을 시작할 현재 Point(x,y)를 큐에 추가합니다.
        Q.offer(new Point86(x,y));

        // 큐가 비어있지 않는 동안 계속 탐색을 진행합니다.
        while(!Q.isEmpty()){
            Point86 current = Q.poll();

            // 현재 노드(current)의 8방향으로 인접한 칸들을 탐색합니다.
            for(int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 다음 위치 (nx, ny)가 격자 범위 내에 있고 (1부터 N까지의 인덱스 사용),
                // 해당 위치가 '1' (아직 방문하지 않은 육지)인 경우
                if(nx >= 1 && nx <= N && ny >= 1 && ny <= N && board[nx][ny] == 1){
                    board[nx][ny] = 0; // 해당 위치를 '0' (방문했음)으로 변경하여 중복 방문을 방지합니다.
                    Q.offer(new Point86(nx,ny)); // 방문한 육지를 큐에 추가하여 다음 번에 탐색할 대상으로 예약합니다.
                }
            }
        }
    }


    public void solution(int[][] board){
        // 격자의 모든 칸을 순회합니다 (인덱스를 1부터 N까지 사용).
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                // 현재 칸이 '1' (육지)인 경우, 새로운 섬의 시작점으로 간주합니다.
                if(board[i][j]==1){
                    answer++; // 섬의 개수를 1 증가시킵니다.
                    board[i][j] = 0; // 현재 섬의 시작점을 '0'으로 변경하여 방문 처리합니다.
                    // 이는 BFS 함수 호출 전에 현재 위치를 미리 방문 처리하여 중복 카운트를 막고
                    // BFS가 현재 위치부터 올바르게 탐색을 시작하도록 합니다.
                    BFS(i,j, board); // 현재 위치에서 BFS를 시작하여 이 섬과 연결된 모든 육지를 방문 처리합니다.
                }
            }
        }
    }


    public static void main(String[] args) {
        Main86 T = new Main86();
        Scanner sc = new Scanner(System.in);
        answer = 0;
        N = sc.nextInt();
        int [][]board = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        T.solution(board);
        System.out.println(answer);
        sc.close();
    }
}