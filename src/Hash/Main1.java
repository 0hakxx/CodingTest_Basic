package Hash;


import java.util.HashMap;
import java.util.Scanner;


class Main1 {
    public char solution(int n, String str) {
        char answer=' ';

        HashMap<Character, Integer> map= new HashMap<>();

        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }


        int max = 0;
        for(char c:map.keySet()){
            if(map.get(c) > max){
                max = Math.max(max, map.get(c));
                answer = c;
            }
        }


        return answer;
    }

    public static void main(String[] args){
        Main1 T = new Main1();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        String str=kb.next();
        System.out.println(T.solution(n, str));
    }
}
