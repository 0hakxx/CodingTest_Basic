import java.util.Scanner;


public class Main1_5 {

//    설명 : 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
//    특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
//    예시 입력 : a#b!GE*T@S
//    예시 출력 : S#T!EG*b@a
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] str = sc.nextLine().toCharArray();

         int left = 0;
        int right = str.length - 1;

        while (left < right) {
            if(!((str[left] >= 'a' && str[left] <= 'z') || (str[left] >= 'A' && str[left] <='Z'))) {
                left++;
            }

            else if(!((str[right] >= 'a' && str[right] <= 'z') || (str[right] >= 'A' && str[right] <= 'Z'))) {
                right--;
            }
            else{
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }
        }
        for(int i=0; i < str.length; i++){
            System.out.print(str[i]);
        }
    }
}

