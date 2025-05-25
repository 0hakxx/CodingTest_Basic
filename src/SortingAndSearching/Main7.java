    package SortingAndSearching;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.Scanner;

    public class Main7 {

        public int solution(int n, int m, int[] arr) {

            int lt = 0;
            int rt = n-1;
            int mid;

            for(int i = 0; i < n/2;  i++){
                mid  = (lt+rt)/2;
                if(arr[mid] == m ){return mid+1;}
                else if(arr[mid] > m){
                    rt = mid-1;
                }
                else{lt = mid+1;}
            }
            return -1;
        }

        public static void main(String[] args){
            Main7 T = new Main7();
            Scanner kb = new Scanner(System.in);
            int n = kb.nextInt();
            int m = kb.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = kb.nextInt();
            }

            Arrays.sort(arr);
            System.out.print(T.solution(n, m, arr));

        }



    }