package String;

import java.util.Scanner;

//코드에서 str = sc.nextLine().toLowerCase();를 사용하여 문자열은 소문자로 변환했지만, 입력받은 문자
//chr는 소문자로 변환하지 않음. 이로 인해 대소문자 구분이 제대로 처리되지 않아 틀림



public class Main1 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str;
            char chr;

            int count = 0;

            str = sc.nextLine().toLowerCase();
            chr = sc.next().toLowerCase().charAt(0);

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == chr) {
                    count++;

                }
            }
            System.out.println(count);
        }
}

