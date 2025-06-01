package Recursive_Tree_Graph;

import java.util.Scanner; // 사용자로부터 입력을 받기 위해 Scanner 클래스를 임포트합니다.
class Main85 {
    // 8방향 탐색을 위한 x축 이동 값 배열 (상, 하, 좌, 우, 좌상, 우상, 좌하, 우하 순서로 되어 있지 않음에 유의)
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,-1,1,-1,1,-1,1};

    static int answer;
    static int N;

    public void DFS(int x, int y, int[][] board){
        // 현재 위치(x, y)에서 8방향으로 인접한 칸들을 탐색합니다.
        for(int i=0; i < 8; i++){
            int nx = x + dx[i]; // 다음 탐색할 x좌표
            int ny = y + dy[i]; // 다음 탐색할 y좌표

            // 다음 위치 (nx, ny)가 격자 범위 내에 있고
            // 해당 위치가 '1' (아직 방문하지 않은 육지)인 경우
            if(nx >= 1 && nx <= N && ny >= 1 && ny <= N && board[nx][ny] == 1){
                board[nx][ny] = 0; // 해당 위치를 '0' (방문했음)으로 변경
                DFS(nx, ny, board); // 변경된 위치에서 다시 DFS를 재귀적으로 호출하여 연결된 모든 육지를 탐색합니다.
            }
        }
    }


    public void solution(int[][] board){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                // 현재 칸이 '1' (육지)인 경우, 새로운 섬의 시작점으로 간주합니다.
                if(board[i][j]==1){
                    answer++; // 섬의 개수를 1 증가시킵니다.
                    board[i][j] = 0; // 현재 섬의 시작점을 '0'으로 변경하여 방문 처리합니다. (매우 중요!)
                    // 이 부분이 없으면 DFS가 해당 지점을 다시 방문할 수 있어 중복 카운트 위험이 있습니다.
                    DFS(i,j, board);
                }
            }
        }
    }
    public static void main(String[] args) {
        Main85 T = new Main85();
        Scanner sc = new Scanner(System.in);

        answer = 0;
        N = sc.nextInt();

        // N+1 x N+1 크기의 2차원 배열을 생성합니다. (인덱스를 1부터 N까지 사용하기 위함)
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