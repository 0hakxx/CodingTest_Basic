package Recursive_Tree_Graph;
import java.awt.*;
import java.util.*;

// 좌표를 나타내는 클래스 (집 또는 피자집의 위치)
class Point87 {
    public int x, y;
    Point87(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main87 {

    static ArrayList<Point87> houses;             // 도시의 모든 집 좌표를 저장하는 리스트
    static ArrayList<Point87> pizzaShops;         // 도시의 모든 피자집 좌표를 저장하는 리스트

    static int N;                               // 도시 격자판 크기 (N x N)
    static int M;                               // 선택할 피자집의 개수
    static int totalPizzaShopCount;             // 전체 피자집 개수
    static int[] selectedPizzaShopIndexes;      // 현재 선택된 M개의 피자집 인덱스를 저장할 배열

    static int answer = Integer.MAX_VALUE;      // 정답: 모든 집의 최소 배달 거리 합 중 최솟값

    /**
     * DFS를 이용해 피자집 M개를 조합으로 선택한다.
     * 조합이 완성되면, 해당 조합으로 도시 전체 피자 배달 거리의 총합을 계산하고
     * 가장 작은 값을 answer에 저장한다.
     *
     * @param level 현재까지 선택한 피자집 수 (0 ~ M)
     * @param start 다음에 선택할 피자집 인덱스의 시작값 (중복 없는 조합을 위해 사용)
     */
    public void DFS(int level, int start) {
        if (level == M) { // M개의 피자집 조합이 완성된 경우
            int sum = 0;  // 현재 조합에서의 도시 전체 배달 거리 합

            // 각 집에 대해 가장 가까운 피자집까지의 거리 계산
            for (Point87 house : houses) {
                int dis = Integer.MAX_VALUE;
                for (int i : selectedPizzaShopIndexes) {
                    Point87 pizza = pizzaShops.get(i);
                    int distance = Math.abs(house.x - pizza.x) + Math.abs(house.y - pizza.y);
                    dis = Math.min(dis, distance);
                }
                sum += dis; // 모든 집의 최소 배달 거리 누적
            }

            // 현재 조합의 거리 합과 기존 최소값 비교하여 더 작은 값으로 갱신
            answer = Math.min(answer, sum);
        } else {
            // 피자집 조합 선택 (중복 없는 조합을 위해 start부터 반복)
            for (int i = start; i < totalPizzaShopCount; i++) {
                selectedPizzaShopIndexes[level] = i;
                DFS(level + 1, i + 1); // 다음 피자집 선택
            }
        }
    }

    public static void main(String[] args) {
        Main87 T = new Main87(); // DFS를 수행하기 위한 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 도시 크기 N, 선택할 피자집 수 M 입력
        N = scanner.nextInt();
        M = scanner.nextInt();

        houses = new ArrayList<>();
        pizzaShops = new ArrayList<>();

        // 도시 격자 입력: 0=빈칸, 1=집, 2=피자집
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = scanner.nextInt();
                if (tmp == 1) houses.add(new Point87(i, j));
                else if (tmp == 2) pizzaShops.add(new Point87(i, j));
            }
        }

        totalPizzaShopCount = pizzaShops.size();   // 전체 피자집 개수 저장
        selectedPizzaShopIndexes = new int[M];     // 피자집 M개 선택을 위한 배열 초기화

        T.DFS(0, 0);  // DFS를 통해 M개 피자집 조합을 탐색 시작
        System.out.println(answer);  // 결과 출력: 최소 도시 피자 배달 거리
        scanner.close();
    }
}
