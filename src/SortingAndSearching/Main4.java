package SortingAndSearching;

import java.util.*;

public class Main4 {

    public Deque<Integer> solution(int array_size, List<Integer> cache) { // array_size : 5, cache (작업 입력 9개)
        Deque<Integer> queue = new ArrayDeque<>();

        for(int tasks : cache) {
            if(queue.contains(tasks)) {
                queue.remove(tasks);
            }
            else if (queue.size() == array_size) {
                queue.removeLast();
            }
            queue.addFirst(tasks);
        }


        return queue;
    }


    public static void main(String[] args) {
        Main4 main = new Main4();

        Scanner sc = new Scanner(System.in);

        int array_size = sc.nextInt(); // 입력 5
        int cache_size = sc.nextInt(); // 입력 9

        List<Integer> cache = new ArrayList<>();

        for (int i = 0; i < cache_size; i++) {
            cache.add(sc.nextInt()); //작업 9개 입력
        }
        System.out.print(main.solution(array_size, cache));

    }
}
