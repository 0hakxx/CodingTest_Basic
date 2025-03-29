import java.util.Scanner;


public class Main1_6 {
//소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
//중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
//첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
//    예시 입력 : ksekkset
//    예시 출력 : kset

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String answer = "";

        if (strLowCheck(str)) {
            for(int i=0; i<str.length(); i++) {
                if(i==str.indexOf(str.charAt(i))) { // i번째 인덱스와, i번째 글자가 같다면..즉 문자 알파벳이 처음으로 등장한다면
                    answer += str.charAt(i);
                }
            }
        }
        System.out.println(answer);
    }


    public static boolean strLowCheck(String str){ //소문자 Check
        char [] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(!(chars[i] >= 'a' || chars[i] <= 'z')){
                return false;
            }
        }
        return true;
    }
}

