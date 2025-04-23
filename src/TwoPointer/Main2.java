package TwoPointer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


public class Main2 {

    public ArrayList<Integer> solution(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> answer = new ArrayList<>();


        for(int i = 0; i < a.size(); i++) {
            if(b.contains(a.get(i))) {
                answer.add(a.get(i));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt(); // 사용자로부터 배열 크기 입력받음
        ArrayList<Integer> a = new ArrayList<>();


        for(int i = 0; i < first; i++) {
            a.add(sc.nextInt());
        }

        Collections.sort(a);//정렬

        int second = sc.nextInt(); // 사용자로부터 배열 크기 입력받음
        ArrayList<Integer> b = new ArrayList<>();

        for(int i = 0; i < second; i++) {
            b.add(sc.nextInt());
        }
        Collections.sort(b);//정렬


        for (int i : T.solution(a,b)) {
            System.out.print(i + " ");
        }

    }
}
