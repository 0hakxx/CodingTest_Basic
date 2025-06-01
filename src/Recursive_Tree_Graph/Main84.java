package Recursive_Tree_Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Point84 {
    int x;
    int y;

    public Point84(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main84 {
    static int N; // 행의 수 (height)
    static int M; // 열의 수 (width)
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌 (행 변화량)
    static int[] dy = {0, 1, 0, -1}; // 상, 우, 하, 좌 (열 변화량)

    static Deque<Point84> Q = new ArrayDeque<>(); // BFS 탐색을 위한 큐

    static int[][] board; // 미로 또는 토마토 상태를 저장하는 배열 (0: 익지 않음, 1: 익음, -1: 벽)
    static int[][] dis;   // 각 토마토가 익는 데 걸린 시간(일수)을 저장하는 배열

    public void BFS() {
        while (!Q.isEmpty()) {
            Point84 tmp = Q.poll(); // 현재 탐색할 토마토 위치

            // 4방향 (상, 하, 좌, 우) 탐색
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                // 1. 다음 위치가 박스 범위 내에 있는지 확인
                // 2. 다음 위치의 토마토가 아직 익지 않았는지 (0) 확인
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && board[nx][ny] == 0) {
                    board[nx][ny] = 1; // 익지 않은 토마토를 익은 상태(1)로 변경
                    Q.offer(new Point84(nx, ny)); // 큐에 추가하여 나중에 탐색
                    // !!! 중요 수정: dis 배열 업데이트 로직
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1; // 현재 토마토까지의 거리에 1을 더함, 즉 토마토가 익는 날 수를 dis 배열에 저장한다.
                }
            }
        }
    }

    public static void main(String[] args) {
        Main84 T = new Main84();
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt(); 
        N = sc.nextInt(); 

        
        board = new int[N + 1][M + 1];
        dis = new int[N + 1][M + 1];

        // 입력 받으면서 초기 익은 토마토를 큐에 넣음
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int status = sc.nextInt();
                board[i][j] = status; 

                // 중요 로직
                // 만약 현재 위치가 익은 토마토(1)라면 BFS의 시작 지점으로 큐에 추가
                if (status == 1) {
                    Q.offer(new Point84(i, j));
                    dis[i][j] = 0; // 시작 지점의 거리는 0으로 초기화
                }
            }
        }

        T.BFS(); // BFS 실행

        int maxDays = 0; // 모든 토마토가 익는 데 걸린 최대 일수 (최단 시간)
        boolean allRipe = true; // 모든 토마토가 익었는지 확인하는 플래그

        // BFS 종료 후 board 배열을 탐색하여 모든 토마토가 익었는지 확인하고, 최대 일수를 찾음
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (board[i][j] == 0) { // 아직 익지 않은 토마토(0)가 남아있다면
                    allRipe = false; // 모든 토마토가 익지 않음
                    break;
                }}}
        if(allRipe){ //모든 토마토가 다 익었다면..최대 일수 구하기
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    maxDays = Math.max(maxDays, dis[i][j]);}}
            System.out.println(maxDays);}
        else {System.out.println(-1);}
        sc.close();
    }
}