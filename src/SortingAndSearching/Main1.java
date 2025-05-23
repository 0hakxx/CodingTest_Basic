package SortingAndSearching;

import com.sun.tools.javac.Main;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public int[] solution(int n, int[] arr) {
        int idx;

        for(int i = 0; i < n; i++){
            idx = i;
            for(int j = i+1; j < n; j++){
                if(arr[idx] > arr[j]){
                    idx = j;
                }
            }
            int temp= arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


    public static void main(String[] args) {
        Main1 main = new Main1();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int x : main.solution(n, arr)){
            System.out.print(x + " ");
        }
    }
}
