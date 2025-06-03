package Greedy;
import java.util.ArrayList;
import java.util.Collections; // Collections.sort() 사용을 위해 추가
import java.util.Scanner;

/*
해당 문제를 이중 for문을 사용 시 지원자의 수 N(5<=N<=30,000)이므로 30,000*30,000 Time Out 에 걸림.
따라서 Body라는 클래스를 만든 뒤, 키(height)를 기준으로 정렬한 뒤 단일 for문을 수행
 */
class Body implements Comparable<Body> {
    int height;
    int weight;

    public Body(int height,int weight){
        this.height=height;
        this.weight=weight;
    }
    // Comparable 인터페이스 구현: Body 객체들을 비교하여 정렬 기준을 정의
    // 현재 구현은 height(키)를 기준으로 내림차순 정렬 (키가 큰 사람부터 앞에 오도록)
    @Override
    public int compareTo(Body o) {
        return o.height - this.height;
    }
}
public class Main1 {
    public int solution(ArrayList<Body> arr) {
        int answer = 0; // 선발되는 선수의 수를 저장할 변수
        // 1. 키(height)를 기준으로 내림차순 정렬
        // Body 클래스의 compareTo 메소드에 의해 키가 큰 순서대로 정렬됨
        Collections.sort(arr);
        // 정렬된 결과 (예시 입력값 기준):
        // (183, 65)
        // (181, 60)
        // (180, 70)
        // (172, 67)
        // (170, 72)
        int maxWeight = Integer.MIN_VALUE; // 현재까지 선발된 선수들 중 가장 무거운 몸무게
        // 2. 정렬된 선수들을 순회하며 선발 여부 결정 (그리디 알고리즘)
        // 키는 이미 내림차순으로 정렬되어 있으므로, 현재 선수를 선발하려면
        // 일단 키가 제일 큰 사람은 무조건 선발됨. 그리고 키가 제일 큰 사람의 몸무게보다 낮은 사람이 있으면 그 사람은 키/몸무게 모두 작으므로 자동 탈락
        // 이제 몸무게로만 판단하여 선발하므로 '키'가 큰 순서대로 정렬되어있으므로, 이전에 선발된 어떤 선수보다 무거우면 된다.
        for (Body b : arr) {
            if (b.weight > maxWeight) {
                maxWeight = b.weight;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main1 T = new Main1();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for(int i=0; i < N; i++){
            arr.add(new Body(sc.nextInt(),sc.nextInt()));
        }

        // solution 메소드 호출 전에 정렬이 필요하므로 Collections.sort()는 solution 내부 또는 main에서 호출
        // 현재는 solution 내부에서 호출되도록 되어있음.

        System.out.println(T.solution(arr));
        sc.close();
    }
}