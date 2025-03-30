package String;

import java.util.Scanner;


public class Main4 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int count = sc.nextInt();


            if(!(count >= 3 && count <= 20)) {
                return ;
            }

            for(int i = 0; i <= count; i++) {
                String str;
                str = sc.nextLine();
                String reverse = "";
                for(int j=str.length()-1 ; j>=0; j--) {

                    reverse += str.charAt(j);
                }

                if(reverse != ""){
                    System.out.println(reverse);
                }

            }
        }
}

