package SortingAndSearching;

import java.util.Scanner;

public class Main2 {

    public int[] solution(int n, int[] arr) {
       for(int i=0; i<n; i++){
           for(int j=0; j<n - 1; j++){
               if(arr[j] > arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
           }
       }
       return arr;
    }


    public static void main(String[] args) {
        Main2 main = new Main2();

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
