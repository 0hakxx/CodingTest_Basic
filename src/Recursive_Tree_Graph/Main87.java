import java.util.*;

class Point {
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main {

    static int N; // 도시 격자판 크기 (N x N)
    static int M; // 선택할 피자집 개수
    static int totalPizzaShopCount; // 전체 피자집 개수
    static int minTotalDeliveryDistance = Integer.MAX_VALUE; // 모든 집의 최소 배달 거리 합 중 최솟값

    static int[] selectedPizzaShopIndexes; // M개의 피자집 조합을 저장할 배열

    static ArrayList<Point> houses; // 모든 집 좌표 리스트
    static ArrayList<Point> pizzaShops; // 모든 피자집 좌표 리스트
    
    public void findMinDeliveryDistance(int level, int start) {
        // M개의 피자집 조합이 완성된 경우
        if (level == M) {
            int currentTotalDeliveryDistance = 0; // 현재 조합의 총 배달 거리 합 초기화

            // 각 집(house)에 대해 최단 피자 배달 거리 계산
            for (Point house : houses) {
                int minDistanceForHouse = Integer.MAX_VALUE; // 현재 집에서 가장 가까운 피자집까지의 거리

                // 선택된 M개의 피자집 중 가장 가까운 피자집 찾기
                for (int selectedPizzaShopIndex : selectedPizzaShopIndexes) {
                    Point selectedPizzaShop = pizzaShops.get(selectedPizzaShopIndex);

                    // 맨해튼 거리 계산: |x1-x2| + |y1-y2|
                    int distance = Math.abs(house.x - selectedPizzaShop.x) + Math.abs(house.y - selectedPizzaShop.y);
                    minDistanceForHouse = Math.min(minDistanceForHouse, distance); // 더 짧은 거리로 갱신
                }
                currentTotalDeliveryDistance += minDistanceForHouse; // 해당 집의 최소 거리를 총 합에 더하기
            }
            // 현재 조합의 총 배달 거리가 전체 최솟값보다 작으면 갱신
            minTotalDeliveryDistance = Math.min(minTotalDeliveryDistance, currentTotalDeliveryDistance);
        }
        // 재귀 호출: M개의 피자집을 조합하는 과정
        else {
            // 다음 피자집을 선택하기 위해 사용 가능한 피자집들을 반복
            for (int i = start; i < totalPizzaShopCount; i++) {
                selectedPizzaShopIndexes[level] = i; // 현재 level에 해당하는 피자집 인덱스 저장
                findMinDeliveryDistance(level + 1, i + 1); // 다음 level의 피자집을 선택하러 재귀 호출
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt(); // 도시 격자판 크기 N 입력
        M = scanner.nextInt(); // 선택할 피자집 개수 M 입력

        pizzaShops = new ArrayList<>(); // 피자집 좌표 리스트 초기화
        houses = new ArrayList<>();     // 집 좌표 리스트 초기화

        // 도시 격자판 데이터 입력받고 집(1)과 피자집(2) 좌표 리스트에 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cellType = scanner.nextInt();
                if (cellType == 1) {
                    houses.add(new Point(i, j)); // 집 좌표 추가
                } else if (cellType == 2) {
                    pizzaShops.add(new Point(i, j)); // 피자집 좌표 추가
                }
            }
        }

        totalPizzaShopCount = pizzaShops.size(); // 전체 피자집 개수 저장
        selectedPizzaShopIndexes = new int[M]; // M개의 피자집 인덱스 저장 배열 초기화

        // DFS 탐색 시작 (level 0, start 인덱스 0부터)
        T.findMinDeliveryDistance(0, 0);

        System.out.println(minTotalDeliveryDistance); // 최종 최소 총 배달 거리 출력
        scanner.close();
    }
}