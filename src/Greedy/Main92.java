package Greedy;
import java.util.*;

class Friend{
    int me;
    int you;
    public Friend(int me, int you) {
        this.me = me;
        this.you = you;
    }
}
public class Main92 {
    static int N;
    static int M;
    public String solution(ArrayList<Friend> friends, Friend friend) {
        String answer = "NO";

        for (int i=0; i<N; i++){
        }
        return answer;
    }
    public static void main(String[] args) {
        Main92 T = new Main92();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ArrayList<Friend> friends = new ArrayList<Friend>();
        for(int i = 0; i < M; i++) {
            friends.add(new Friend(sc.nextInt(), sc.nextInt()));
        }
        Friend searchFriend = new Friend(sc.nextInt(), sc.nextInt());
        System.out.println(T.solution(friends, searchFriend));
    }
}
