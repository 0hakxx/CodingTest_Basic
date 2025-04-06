package Array;

import java.util.Scanner;

public class Main3 {
    public void solution(int[] array1, int[] array2) {

        for (int i = 0; i < array1.length; i++) {
            if((array1[i] == 1 && array2[i]== 2) ||(array1[i] == 2 && array2[i]== 3) || (array1[i] == 3 && array2[i]== 1) ){
                System.out.println("B");
            }
            if((array2[i] == 1 && array1[i]== 2) ||(array2[i] == 2 && array1[i]== 3) || (array2[i] == 3 && array1[i]== 1) ){
                System.out.println("A");
            }
            if(array1[i] == array2[i]){System.out.println("D");}
        }

    }

    public static void main(String[] args) {
        Main3 T = new Main3();
        Scanner kb = new Scanner(System.in);
        int size = kb.nextInt();

        int[] arr1 = new int[size];
        for (int i = 0; i < size; i++) {
            arr1[i] = kb.nextInt();
        }

        int[] arr2 = new int[size];
        for (int i = 0; i < size; i++) {
            arr2[i] = kb.nextInt();
        }

        T.solution(arr1, arr2);
    }
}
