package Array;

import java.util.Scanner;

public class Main2 {
    public int solution(int[] array) {
        int count = 1;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                count++;
                max = array[i];

            }
        }
        return count;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner kb = new Scanner(System.in);
        int size = kb.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(arr));
    }
}
