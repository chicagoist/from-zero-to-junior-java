package lesson09.task1.classwork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Director worker1 = new Director();

        Worker workerW = (int n) -> {
            System.out.println("....");
            return "I working today for " + n + " hours";
        };

        // version 1
        DirectorOrigin worker2 = new DirectorOrigin();
        worker2.startWork(new WorkerOrigin() {
            @Override
            public void work() {
                System.out.println("Start worker " + worker2.getClass()
                        .getName());
            }
        });

        // version 2
        worker2.startWork(() -> System.out.println("Start worker " + worker2.getClass().getName()));

        String result = worker1.startWork(workerW, 5);
        String result1 = worker1.startWork((n) -> {
            for(int i = 1; i < n; i++) {
                System.out.println("....");
            }
            return "InterfaceI working today for " + n + " hours";
        }, 2);

        System.out.println(result);
        System.out.println(result1);

        // Фильтр с Predicate
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random() * 1000));
        }

        Predicate predicate = (n) -> {
            return n % 2 == 0;
        };

        // Разные варианты
        //   List<Integer> filtered = filter(numbers,predicate);
          List<Integer> filtered = filter(numbers,(n) -> n % 2 == 0);
/*        List<Integer> filtered = filter(numbers,(n) -> {
            return n % 3 == 0;
        });
*/
        System.out.println("---FILTERED---");
        System.out.println(filtered);
    }


    static List<Integer> filter(List<Integer> numbers, Predicate obj) {
        List<Integer> result = new ArrayList<>();
        for(int i : numbers) {
            if(obj.test(i)) {
                result.add(i);
            }
        }
        Collections.sort(result);
        return result;
    }
}
