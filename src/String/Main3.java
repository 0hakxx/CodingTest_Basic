package String;

import java.util.Scanner;

//이 문제의 핵심은 split.(" ")
public class Main3 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str;
            String s = "";
            int count = 0;



            str = sc.nextLine();
            System.out.println(solution(str));

            }
    public static String solution(String str) {
        String result = "";
        String[] strArr = str.split(" ");
        for(int i = 0; i < strArr.length; i++) {
            if(strArr[i].length() > result.length()) {
                result = strArr[i];
            }

        }
        return result;
    }
}




