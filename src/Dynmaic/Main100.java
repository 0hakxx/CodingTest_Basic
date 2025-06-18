    package Dynmaic;

    import java.util.*;

    public class Main100 {
        static int[] dy;
        public int solution(int[] arr, int n) {
            // 엣지 케이스 처리: 배열의 길이가 0이거나 1일 때
            if (n == 0) return 0;
            if (n == 1) return 1;
            int answer = 0;
            dy = new int[n];
            dy[0] = 1;
            for(int i = 1; i < n; i++) {
                int max = 0;
                for(int j=0; j < i; j++){
                    if(arr[j] < arr[i]) max = Math.max(max, dy[j]);
                }
                dy[i] = max+1;
                answer = Math.max(answer, dy[i]);
            }
            return answer;
        }

        public static void main(String[] args) {
            Main100 T = new Main100();
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(T.solution(arr, N));
            in.close();
        }
    }