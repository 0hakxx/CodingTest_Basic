package SortingAndSearching;

import java.util.*;

public class Main4_2 {
    public int[] solution(int size, int n, int[] arr){

        int[] cache=new int[size];

        int pos = -1; // x가 cache에 있으면 그 위치 저장

        for(int x : arr){
            boolean flag = true;

            
            for(int i = 0; i < size; i++){if(cache[i]==x){flag = false; pos=i;}} //cache에 받은 작업이 이미 존재한다면..flag false로 바꾸고, cache 인덱스로 pos 저장

            if(flag){ //만약 cache에 작업이 없다면??, 뒤로 한칸 씩 떙겨, 1번 인덱스까지만..
                for(int i=size-1; i >=1; i--){
                    int temp = cache[i-1];
                    cache[i] = temp;
                }
                cache[0] = x;
            }
            else{ //만약 cache에 작업이 있다면? pos 인덱스부터 1칸씩 뒤로 밀림.
                for(int i = pos; i >=1; i--){
                    int temp = cache[i-1];
                    cache[i] = temp;
                }
                cache[0] = x;
            }

        }

        return cache;

    }
    public static void main(String[] args){
        Main4_2 T = new Main4_2();
        Scanner kb = new Scanner(System.in);
        int s=kb.nextInt();
        int n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++) arr[i]=kb.nextInt();
        for(int x : T.solution(s, n, arr)) System.out.print(x+" ");
    }
}