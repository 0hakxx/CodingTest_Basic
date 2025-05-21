package Hash;


import java.util.HashMap;
import java.util.Scanner;


class Main2 {
    public String solution(String str, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        for(int j=0;j<str2.length();j++){
            char c = str2.charAt(j);
            if(!map.containsKey(c) || map.get(c) == 0){
                return "NO";
            }
            map.put(c, map.get(c) - 1);
        }
        return "YES";
    }

    public static void main(String[] args){
        Main2 T = new Main2();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        String str2 = kb.next();
        System.out.println(T.solution(str, str2));
    }
}
