package Bai_Thread3;

public class BakeryMain {
    public static void main(String[] args) {
        Bakery bakery = new Bakery();
        Thread producer = new Thread(bakery::produceBread);
        producer.start();

        new Thread(() -> bakery.consumeBread("Khách A")).start();
        new Thread(() -> bakery.consumeBread("Khách B")).start();
    }
}
