package SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public List<Integer> solution(int n, int[] arr){

        List<Integer> answer=new ArrayList<>();

        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);

        for(int i=0;i<n;i++){
            if(temp[i] != arr[i]){
                answer.add(i+1);
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Main5 T = new Main5();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }
        for(int x:T.solution(n,arr)){
            System.out.print(x + " ");
        }
    }
}