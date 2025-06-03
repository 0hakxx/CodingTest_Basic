import java.util.*;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Meeting o) {
        // 1. 끝나는 시간이 같을 경우 (동일한 종료 시간)
        if(this.end == o.end){
            // 시작 시간을 기준으로 오름차순 정렬합니다.
            // 이렇게 하면 끝나는 시간이 3으로 같은 회의 (3,3), (1,3), (2,3)이 있을 때
            // (1,3) -> (2,3) -> (3,3) 순으로 정렬됩니다.
            // 이는 다음 회의를 선택할 때 유리합니다.
            return this.start - o.start;
        }
        // 2. 끝나는 시간이 다를 경우
        // 끝나는 시간을 기준으로 오름차순 정렬합니다.
        return this.end - o.end;
    }
}

public class Main{

    // solution 메소드는 주어진 회의 목록에서 회의실을 사용할 수 있는 최대 회의 수를 계산합니다.
    public int solution(ArrayList<Meeting> meetings) {
        int answer = 0; // 선택된 회의의 수를 저장할 변수

        // Collections.sort() 메소드를 사용하여 meetings 리스트를 정렬합니다.
        // Meeting 클래스에 구현된 compareTo 메소드의 기준(끝나는 시간 -> 시작 시간)에 따라 정렬됩니다.
        Collections.sort(meetings);

        // 현재 선택된 회의의 끝나는 시간을 저장하는 변수입니다.
        // 첫 회의는 어떤 시간에도 시작할 수 있으므로 0으로 초기화합니다.
        int endTime = 0;

        // 정렬된 회의 목록을 순회합니다.
        for(Meeting meeting : meetings){
            // 현재 회의의 시작 시간이 이전에 선택된 회의의 끝나는 시간보다
            // 같거나 크다면 (즉, 겹치지 않는다면) 이 회의를 선택할 수 있습니다.
            // '한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다'는 조건 때문에 >= 입니다.
            if(meeting.start >= endTime){
                answer++; // 회의 수를 증가시킵니다.
                endTime = meeting.end; // 현재 선택된 회의의 끝나는 시간을 갱신합니다.
                // 다음 회의를 선택할 때 이 시간을 기준으로 판단하게 됩니다.
            }
        }
        return answer; // 최대 회의 수를 반환합니다.
    }

    public static void main(String[] args){
        Main T = new Main(); // Main 클래스의 인스턴스 생성
        Scanner sc = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체 생성

        // 회의의 총 개수 N을 입력받습니다.
        int N = sc.nextInt();
        // Meeting 객체를 저장할 ArrayList를 생성합니다.
        ArrayList<Meeting> meetings = new ArrayList<Meeting>();

        // N번 반복하여 각 회의의 시작 시간과 끝나는 시간을 입력받아 Meeting 객체를 생성하고 리스트에 추가합니다.
        for (int i = 0; i < N; i++) {
            meetings.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }

        // 빨리 끝나는 회의를 먼저 선택하는 그리디 알고리즘을 사용해야 최대한 많은 회의를 넣을 수 있습니다.
        // solution 메소드를 호출하여 결과를 출력합니다.
        System.out.println(T.solution(meetings));

        sc.close(); // Scanner 리소스 해제
    }
}

/*
예시 입력:
N = 3
회의 1: (3, 3)
회의 2: (1, 3)
회의 3: (2, 3)

이 예시 입력에 대한 코드 동작 흐름 주석:

1.  **입력 처리:**
    * `N = 3`
    * `meetings` 리스트에 다음 Meeting 객체들이 추가됩니다:
        * `Meeting(3, 3)`
        * `Meeting(1, 3)`
        * `Meeting(2, 3)`

2.  **solution 메소드 호출:**
    * `answer = 0`
    * `endTime = 0`

3.  **Collections.sort(meetings);**
    * Meeting 클래스의 `compareTo` 메소드에 따라 정렬됩니다.
    * 원래 순서: `[(3, 3), (1, 3), (2, 3)]`
    * `compareTo` 로직:
        * `m1.end == m2.end` 인 경우 `m1.start - m2.start`
        * `m1.end != m2.end` 인 경우 `m1.end - m2.end`
    * 모든 회의의 `end` 시간이 3으로 동일하므로, `start` 시간을 기준으로 오름차순 정렬됩니다.
    * 정렬된 `meetings` 리스트: `[(1, 3), (2, 3), (3, 3)]`

4.  **for(Meeting meeting : meetings) 루프 시작:**

    * **첫 번째 회의: `meeting = (1, 3)`**
        * `meeting.start (1)` >= `endTime (0)` -> true
        * `answer`는 `0`에서 `1`로 증가.
        * `endTime`은 `meeting.end (3)`으로 갱신. (현재 `endTime = 3`)

    * **두 번째 회의: `meeting = (2, 3)`**
        * `meeting.start (2)` >= `endTime (3)` -> false (2는 3보다 크거나 같지 않음, 겹침)
        * 이 회의는 선택되지 않음. `answer`와 `endTime`은 그대로.

    * **세 번째 회의: `meeting = (3, 3)`**
        * `meeting.start (3)` >= `endTime (3)` -> true (같으므로 선택 가능)
        * `answer`는 `1`에서 `2`로 증가.
        * `endTime`은 `meeting.end (3)`으로 갱신. (현재 `endTime = 3`)

5.  **루프 종료.**

6.  **return answer;**
    * `answer` 값인 `2`가 반환됩니다.

7.  **System.out.println(T.solution(meetings));**
    * 최종 결과 `2`가 콘솔에 출력됩니다.

이 입력에 대한 출력은 `2`가 됩니다. (1시~3시 회의와 3시~3시 회의, 총 2개 선택 가능)
*/