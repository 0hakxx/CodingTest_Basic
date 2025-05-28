package Recursive_Tree_Graph;





class Main62_6 {
    static int n;
    static int[] ch;

    public void DFS(int L){
        if(L == n +1){
            String tmp = "";
            for(int i = 1; i <= n; i++){
                if(ch[i] == 1) { // i번 원소가 현재 부분집합에 포함되어 있다면
                    tmp += (i + " "); // tmp 문자열에 i와 공백을 추가
                }
            }
            System.out.println(tmp);
        }
        else{
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }

    public static void main(String[] args) {

        Main62_6 T = new Main62_6();
        n = 3;
        ch = new int[n+1];
        T.DFS(1);

    }
}