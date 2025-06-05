package Greedy;

import java.util.*;


class lecture implements Comparable<lecture> {
    int money; // 강의 완료 시 얻을 수입
    int day;   // 강의 마감 기한 (이 날짜까지 완료해야 함)
    lecture(int money, int day){
        this.money = money;
        this.day = day;
    }
    @Override
    public int compareTo(lecture o) {
        // day가 큰(마감 기한이 늦은) 요소가 리스트의 앞쪽에 위치
        return o.day - this.day;
    }
}

public class Main91 {
    static int N;   // 전체 강의의 수
    static int MAX; // 주어진 마감 기한 중 가장 큰 값 (최대 마감일)
    public int solution(ArrayList<lecture> lectures) {
        int answer = 0;
        //PriorityQueue(우선순위 큐)를 생성한다. 해당 큐는 수입(Integer)을 넣으며 수입이 제일 큰 것을 우선순위로 높게 설정
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        //마감 기한이 가장 늦은 강의부터 리스트의 앞에 위치
        Collections.sort(lectures);

        // 그리디 알고리즘의 핵심 루프: 가장 늦은 마감일(MAX)부터 1일까지 역순으로 탐색
        int j = 0; // lectures 리스트를 순회하기 위한 인덱스
        for(int i = MAX; i >= 1; i--) { 
            for(; j < N; j++){ // j는 이전에 순회했던 지점부터 다시 시작 (중요!)
                // 현재 검토 중인 강의(lectures.get(j))의 마감 기한(day)이
                // 현재 날짜(i)보다 작아지면 (즉, 현재 날짜에는 수행할 수 없는 강의가 되면)
                // 더 이상 뒤의 강의들도 현재 날짜에는 마감 기한을 넘길 것이므로 반복을 중단
                if(lectures.get(j).day < i){
                    break;
                }
                // 마감 기한이 현재 날짜 `i` 이전에 완료 가능한 강의라면 해당 강의의 수입을 PriorityQueue에 추가
                pQ.offer(lectures.get(j).money);
            }
            if(!pQ.isEmpty()) {
                answer += pQ.poll(); // pQ.poll()은 가장 큰 수입을 가진 강의의 수입을 반환 후 제거
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main91 T = new Main91(); // Main 클래스의 인스턴스 생성
        Scanner sc = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체 생성

        N = sc.nextInt();
        MAX = Integer.MIN_VALUE;
        ArrayList<lecture> lectures = new ArrayList<lecture>();
        for(int i = 0; i < N; i++){
            int money = sc.nextInt();
            int day = sc.nextInt();
            MAX = Math.max(MAX, day);
            lectures.add(new lecture(money, day));
        }
        System.out.println(T.solution(lectures));
        sc.close();
    }
}

/*
예시 입력:
N = 6
강의 1: (50, 2)  -> 수입 50, 마감 2일
강의 2: (20, 1)  -> 수입 20, 마감 1일
강의 3: (40, 2)  -> 수입 40, 마감 2일
강의 4: (60, 3)  -> 수입 60, 마감 3일
강의 5: (30, 3)  -> 수입 30, 마감 3일
강의 6: (30, 1)  -> 수입 30, 마감 1일
MAX = 3

**코드 동작 흐름 상세 설명:**

1.  **입력 처리:**
    * `N = 6`
    * `lectures` 리스트에 `lecture` 객체들이 추가됩니다: `[(50, 2), (20, 1), (40, 2), (60, 3), (30, 3), (30, 1)]`
    * `MAX`는 `3`으로 설정됩니다.


2.  **Collections.sort(lectures);**
    * `lecture` 클래스의 `compareTo` 메소드에 따라 'day' 기준으로 내림차순 정렬됩니다.
    * 정렬된 `lectures` 리스트:
      `[ (60, 3), (30, 3), (50, 2), (40, 2), (20, 1), (30, 1) ]`
      (동일한 day를 가진 경우, money에 대한 추가 정렬 기준이 없으므로 입력 순서나 내부 구현에 따라 순서가 달라질 수 있으나, 이 문제에서는 결과에 영향을 주지 않습니다.)

3.  **그리디 루프 시작: `for(int i = MAX; i >= 1; i--)`**
    * `j = 0` (lectures 리스트의 인덱스)

    * **`i = 3` (현재 날짜 3일차)**
        * **내부 for 루프 (`for(; j < N; j++)`) 시작:**
            * `j = 0`: `lectures.get(0) = (60, 3)`. `lectures.get(0).day (3)` < `i (3)` -> false.
              `pQ.offer(60)` -> `pQ: [60]`. `j`는 1로 증가.
            * `j = 1`: `lectures.get(1) = (30, 3)`. `lectures.get(1).day (3)` < `i (3)` -> false.
              `pQ.offer(30)` -> `pQ: [60, 30]` (내부 힙 구조). `j`는 2로 증가.
            * `j = 2`: `lectures.get(2) = (50, 2)`. `lectures.get(2).day (2)` < `i (3)` -> true. `break;` (내부 루프 종료)
        * **`if(!pQ.isEmpty())`:** `pQ`는 `[60, 30]`으로 비어있지 않음.
            * `answer += pQ.poll()`: `pQ.poll()`은 `60`을 반환. `answer = 0 + 60 = 60`. `pQ: [30]`
        * **3일차에 선택된 강의: (60, 3) (수입 60)**

    * **`i = 2` (현재 날짜 2일차)**
        * **내부 for 루프 (`for(; j < N; j++)`) 시작:** (`j`는 2에서 시작)
            * `j = 2`: `lectures.get(2) = (50, 2)`. `lectures.get(2).day (2)` < `i (2)` -> false.
              `pQ.offer(50)` -> `pQ: [50, 30]`. `j`는 3으로 증가.
            * `j = 3`: `lectures.get(3) = (40, 2)`. `lectures.get(3).day (2)` < `i (2)` -> false.
              `pQ.offer(40)` -> `pQ: [50, 40, 30]` (내부 힙 구조). `j`는 4로 증가.
            * `j = 4`: `lectures.get(4) = (20, 1)`. `lectures.get(4).day (1)` < `i (2)` -> true. `break;` (내부 루프 종료)
        * **`if(!pQ.isEmpty())`:** `pQ`는 `[50, 40, 30]`으로 비어있지 않음.
            * `answer += pQ.poll()`: `pQ.poll()`은 `50`을 반환. `answer = 60 + 50 = 110`. `pQ: [40, 30]`
        * **2일차에 선택된 강의: (50, 2) (수입 50)**

    * **`i = 1` (현재 날짜 1일차)**
        * **내부 for 루프 (`for(; j < N; j++)`) 시작:** (`j`는 4에서 시작)
            * `j = 4`: `lectures.get(4) = (20, 1)`. `lectures.get(4).day (1)` < `i (1)` -> false.
              `pQ.offer(20)` -> `pQ: [40, 30, 20]`. `j`는 5로 증가.
            * `j = 5`: `lectures.get(5) = (30, 1)`. `lectures.get(5).day (1)` < `i (1)` -> false.
              `pQ.offer(30)` -> `pQ: [40, 30, 20, 30]` (내부 힙 구조). `j`는 6으로 증가.
            * `j = 6`: `j < N` (6 < 6) -> false. (내부 루프 종료)
        * **`if(!pQ.isEmpty())`:** `pQ`는 `[40, 30, 20, 30]`으로 비어있지 않음.
            * `answer += pQ.poll()`: `pQ.poll()`은 `40`을 반환. `answer = 110 + 40 = 150`. `pQ: [30, 20, 30]`
        * **1일차에 선택된 강의: (40, 2) (수입 40)**

5.  **루프 종료.**

6.  **return answer;**
    * `answer` 값인 `150`이 반환됩니다.

7.  **System.out.println(T.solution(lectures));**
    * 최종 결과 `150`이 콘솔에 출력됩니다.

**최종 선택된 강의 (예시):**
* 3일차에 마감된 (60, 3) (수입 60)
* 2일차에 마감된 (50, 2) (수입 50)
* 1일차에 마감된 (40, 2) (수입 40)

**총 수입: 60 + 50 + 40 = 150**
*/