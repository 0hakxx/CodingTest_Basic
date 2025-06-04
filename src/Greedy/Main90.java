package Greedy;

import java.util.*;

class Time implements Comparable<Time>{
    int time; // 이벤트 시간
    char state; // 's'는 회의 시작, 'e'는 회의 끝을 의미.
    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Time o) {
        // 1. 이벤트 발생 시간이 같을 경우
        if(this.time == o.time) {
            // 시간이 같을 경우, 'e'(끝나는 이벤트)가 's'(시작하는 이벤트)보다 앞에 오도록 정렬
            // 이 정렬 방식은 매우 중요
            // 예를 들어, (10, 's')와 (10, 'e')가 있을 때, (10, 'e')가 먼저 오도록
            // 끝나는 회의를 먼저 처리하여 count를 감소시킨 후, 시작하는 회의를 처리하여 count를 증가
            // 이렇게 처리하지 않으면  count+1 이 먼저 된 뒤에 answer = Math.max(answer, count);으로 저장되어 정답이 2가 아닌 3으로 변경됨.
            return this.state - o.state;
        }
        // 2. 이벤트 발생 시간이 다를 경우
        // 발생 시간을 기준으로 오름차순 정렬합니다.
        else return this.time - o.time;
    }
}

public class Main90 {
    public int solution(ArrayList<Time> times){
        Collections.sort(times);

        int answer = Integer.MIN_VALUE; // 최대 동시 회의 수를 저장할 변수 (가장 작은 값으로 초기화)
        int count = 0; // 현재 시점의 동시 진행 회의 수를 저장할 변수
        for(Time time : times){
            if(time.state == 's') { // 회의 시작 이벤트일 경우
                count++; // 현재 동시 진행 회의 수를 1 증가시킵니다.
            } else { // 회의 끝 이벤트일 경우
                count--; // 현재 동시 진행 회의 수를 1 감소시킵니다.
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    public static void main(String[] args) {
        ArrayList<Time> times = new ArrayList<Time>();
        Main90 T = new Main90();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            int startTime = sc.nextInt(); // 회의 시작 시간
            int endTime = sc.nextInt();   // 회의 끝나는 시간
            times.add(new Time(startTime, 's')); // 시작 이벤트 추가
            times.add(new Time(endTime, 'e'));     // 끝 이벤트 추가
        }
        System.out.println(T.solution(times));
        sc.close(); // Scanner 리소스 해제
    }
}

/*
예시 입력:
5
14 18
12 15
15 20
20 30
5 14

**시간 막대 그림 및 코드 동작 흐름 설명:**

1.  **입력 처리 및 Metting 객체 생성:**
    N = 5
    입력된 회의들은 각각 's' (시작) 이벤트와 'e' (종료) 이벤트로 분리되어 `mettings` 리스트에 추가됩니다.

    원래 회의들:
    - (14, 18)
    - (12, 15)
    - (15, 20)
    - (20, 30)
    - (5, 14)

2.  **Collections.sort(mettings);**
    정렬 기준:
    1.  `time` (시간) 기준으로 오름차순.
    2.  `time`이 같으면, 'e'가 's'보다 앞에 오게 정렬.

    정렬된 `mettings` 리스트:
    `[ (5, 's'), (12, 's'), (14, 'e'), (14, 's'), (15, 'e'), (15, 's'), (18, 'e'), (20, 'e'), (20, 's'), (30, 'e') ]`

    **시간 막대 그림:**
    (시간 축: 0 ---- 5 ---- 10 ---- 12 ---- 14 ---- 15 ---- 18 ---- 20 ---- 25 ---- 30 ----)

    회의 1:           [14, 18]
    회의 2:     [12, 15]
    회의 3:             [15, 20]
    회의 4:                       [20, 30]
    회의 5:   [5, 14]

3.  **solution 메소드 실행:**
    `answer = Integer.MIN_VALUE`
    `count = 0`

    **루프 순회:**

    * **Metting(5, 's')**:
        * `state == 's'` 이므로 `count++` -> `count` = 1
        * `answer = Math.max(MIN_VALUE, 1)` -> `answer` = 1
        * **현재 동시 진행 회의 수: 1**
        (5시부터 (5,14) 회의 시작)

    * **Metting(12, 's')**:
        * `state == 's'` 이므로 `count++` -> `count` = 2
        * `answer = Math.max(1, 2)` -> `answer` = 2
        * **현재 동시 진행 회의 수: 2**
        (12시부터 (12,15) 회의 시작. 현재 (5,14)와 (12,15) 진행 중)

    * **Metting(14, 'e')**:
        * `state == 'e'` 이므로 `count--` -> `count` = 1
        * `answer = Math.max(2, 1)` -> `answer` = 2
        * **현재 동시 진행 회의 수: 1**
        (14시에 (5,14) 회의 종료. (12,15)만 진행 중)

    * **Metting(14, 's')**:
        * `state == 's'` 이므로 `count++` -> `count` = 2
        * `answer = Math.max(2, 2)` -> `answer` = 2
        * **현재 동시 진행 회의 수: 2**
        (14시에 (14,18) 회의 시작. (12,15)와 (14,18) 진행 중)

    * **Metting(15, 'e')**:
        * `state == 'e'` 이므로 `count--` -> `count` = 1
        * `answer = Math.max(2, 1)` -> `answer` = 2
        * **현재 동시 진행 회의 수: 1**
        (15시에 (12,15) 회의 종료. (14,18)만 진행 중)

    * **Metting(15, 's')**:
        * `state == 's'` 이므로 `count++` -> `count` = 2
        * `answer = Math.max(2, 2)` -> `answer` = 2
        * **현재 동시 진행 회의 수: 2**
        (15시에 (15,20) 회의 시작. (14,18)과 (15,20) 진행 중)

    * **Metting(18, 'e')**:
        * `state == 'e'` 이므로 `count--` -> `count` = 1
        * `answer = Math.max(2, 1)` -> `answer` = 2
        * **현재 동시 진행 회의 수: 1**
        (18시에 (14,18) 회의 종료. (15,20)만 진행 중)

    * **Metting(20, 'e')**:
        * `state == 'e'` 이므로 `count--` -> `count` = 0
        * `answer = Math.max(2, 0)` -> `answer` = 2
        * **현재 동시 진행 회의 수: 0**
        (20시에 (15,20) 회의 종료. 이제 진행 중인 회의 없음)

    * **Metting(20, 's')**:
        * `state == 's'` 이므로 `count++` -> `count` = 1
        * `answer = Math.max(2, 1)` -> `answer` = 2
        * **현재 동시 진행 회의 수: 1**
        (20시에 (20,30) 회의 시작)

    * **Metting(30, 'e')**:
        * `state == 'e'` 이므로 `count--` -> `count` = 0
        * `answer = Math.max(2, 0)` -> `answer` = 2
        * **현재 동시 진행 회의 수: 0**
        (30시에 (20,30) 회의 종료)
*/