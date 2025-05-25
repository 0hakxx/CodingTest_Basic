package SortingAndSearching;

import java.util.*;

public class Main6 {

    public static void main(String[] args){
        Main6 T = new Main6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Point> arr = new ArrayList<Point>();

        for (int i = 0; i < n; i++) {
            arr.add(new Point(kb.nextInt(), kb.nextInt()));
        }
        Collections.sort(arr);
        for(Point p : arr){
            System.out.println(p.x + " " + p.y);
        }
    }

    static class Point implements Comparable<Point>{
        public int x, y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Point p){
            if(this.x == p.x){
                return this.y-p.y;
            }
            else
                return this.x-p.x;
        }
    }

}