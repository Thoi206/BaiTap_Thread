package Bai_Thread001;

class PrintNumber {
    private int number = 1;
    private final int LIMIT = 10;

    public synchronized void printOdd() {
        while (number < LIMIT) {
            while (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread 1: " + number);
            number++;
            notify();
        }
    }

    public synchronized void printEven() {
        while (number <= LIMIT) {
            while (number % 2 == 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread 2: " + number);
            number++;
            notify();
        }
    }
}
