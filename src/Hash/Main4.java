package Hash;


import java.util.HashMap;
import java.util.Scanner;


class Main4 {
    public int solution(String Sstr, String Tstr) {
        int answer = 0;

        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for(int i=0; i < Tstr.length(); i++) {
            bm.put(Tstr.charAt(i), bm.getOrDefault(Tstr.charAt(i), 0) + 1);
        }

        for (int i = 0; i < Tstr.length() - 1; i++) {
            am.put(Sstr.charAt(i), am.getOrDefault(Sstr.charAt(i), 0) + 1);
        }


        int lt = 0;
        for(int rt=Tstr.length()-1;  rt<Sstr.length(); rt++){
            am.put(Sstr.charAt(rt), am.getOrDefault(Sstr.charAt(rt), 0) + 1);
            if(am.equals(bm)){
                answer++;
            }
            am.put(Sstr.charAt(lt), am.getOrDefault(Sstr.charAt(lt), 0) - 1);
            if(am.get(Sstr.charAt(lt)) == 0){
                am.remove(Sstr.charAt(lt));
            }
            lt++;
        }
        return answer;
    }

    public static void main(String[] args){
        Main4 T = new Main4();
        Scanner kb = new Scanner(System.in);
        String Sstr=kb.next();
        String Tstr=kb.next();
        System.out.println(T.solution(Sstr, Tstr));
    }
}
