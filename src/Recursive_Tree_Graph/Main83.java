package Recursive_Tree_Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Point83{
    int x;
    int y;
    public Point83(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Main83 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int nx, ny;

    static int[][] board = new int[8][8];
    static int[][] dis = new int[8][8];

    static int answer;

    public void BFS(int x, int y){
        Deque<Point83> Q = new ArrayDeque<>();
        Q.offer(new Point83(x,y));

        while(!Q.isEmpty()){
            Point83 tmp = Q.poll();
            for(int i=0; i < 4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx>=1 && ny>=1 && nx<=7 && ny<=7 && board[nx][ny]==0){
                    Q.offer(new Point83(nx,ny));
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }


        }


    public static void main(String[] args) {
        Main83 T = new Main83();

        Scanner sc = new Scanner(System.in);
        for (int i=1; i<= 7; i++){
            for (int j=1; j<= 7; j++){
                board[i][j] = sc.nextInt();
            }
        }


        board[1][1] = 1;
        T.BFS(1,1);
        if (dis[7][7] == 0) {
            System.out.println(-1); // 도달할 수 없으므로 -1 출력
        } else {
            System.out.println(dis[7][7]); // 최단 거리 출력
        }

    }
}