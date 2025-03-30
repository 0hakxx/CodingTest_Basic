package String;

import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str;
            String s = "";


            str = sc.nextLine();

            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    s+= str.toUpperCase().charAt(i);
                }
                else{
                   s+=str.toLowerCase().charAt(i);
                }

            }
            System.out.println(s);

        }
}

