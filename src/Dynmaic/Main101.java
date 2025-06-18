package Dynmaic;

import java.util.*;

class Brick implements Comparable<Brick> {
    int width;
    int height;
    int weight;

    Brick(int width, int height, int weight){
        this.width = width;
        this.height = height;
        this.weight = weight;
    }
    @Override
    public int compareTo(Brick o) {
        return o.width - this.width;
    }
}

public class Main101 {
    static int[] dy;
    public int solution(ArrayList<Brick> bricks,int n) {
        int answer = 0;
        Collections.sort(bricks);
        dy[0] = bricks.get(0).height;
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(bricks.get(j).weight > bricks.get(i).weight) max = Math.max(max, dy[j]);
            }
            dy[i] = max + bricks.get(i).height;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        Main101 T = new Main101();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n];
        ArrayList<Brick> bricks = new ArrayList<Brick>();
        for (int i = 0; i < n; i++) {
            int width = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            bricks.add(new Brick(width, height, weight));
        }
        System.out.println(T.solution(bricks, n));
    }
}