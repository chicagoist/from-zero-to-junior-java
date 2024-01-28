package lesson09.task1.classwork;

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


    }
}
