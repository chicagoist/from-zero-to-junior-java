package lesson09.task1.classwork;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Director worker1 = new Director();
        // version 1
        worker1.startWork(new Worker() {
            @Override
            public void work() {
                System.out.println("Start worker " + worker1.getClass().getName());
            }
        });

        // version 2
        worker1.startWork( () -> System.out.println("Start worker " + worker1.getClass().getName()));

    }
}
