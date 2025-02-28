package Bai_Thread001;

public class OddEvenThread {
    public static void main(String[] args) {
        PrintNumber pn = new PrintNumber();

        Thread t1 = new Thread(pn::printOdd);
        Thread t2 = new Thread(pn::printEven);

        t1.start();
        t2.start();
    }
}
