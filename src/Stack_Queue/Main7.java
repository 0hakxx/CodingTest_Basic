package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main7 {
    public int solution(int M, Person[] persons) {
        int answer = 0;

        Deque<Person> dq = new ArrayDeque<>();
        for(int i = 0 ; i < persons.length ; i++){
            dq.add(persons[i]);
        }

        while(!dq.isEmpty()){
            boolean hasHigherRisk = false;
            Person check = dq.poll();
            for(Person  x : dq) {
                if(check.getrisk() < x.getrisk()) {
                    hasHigherRisk = true;
                }
            }
            if(hasHigherRisk){
                dq.offer(check);
            }else{
                answer++;
                if(check.getp() == M){return answer;}
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Main7 T = new Main7();

        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        int M = sc.nextInt();

        Person[] persons = new Person[N];

        for(int i = 0 ; i < N ; i++){
            int risk = sc.nextInt();
            int p = i;
            persons[i] = T.new Person();
            persons[i].set(p, risk);

        }


        System.out.println(T.solution(M, persons));
    }

    public class Person{
        int p;
        int risk;
        public void set(int p, int risk){
            this.p = p;
            this.risk = risk;
        }

        public int getp(){
            return this.p;
        }

        public int getrisk(){
            return this.risk;
        }
    }
}
