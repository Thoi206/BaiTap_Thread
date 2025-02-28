package Bai_Thread02;

public class TicketSelling {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        Runnable task = () -> {
            String stationName = Thread.currentThread().getName();
            while (true) {
                synchronized (counter) {
                    if (counter != null) {
                        counter.sellTicket(stationName);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Thread station1 = new Thread(task, "Trạm 1");
        Thread station2 = new Thread(task, "Trạm 2");
        Thread station3 = new Thread(task, "Trạm 3");

        station1.start();
        station2.start();
        station3.start();
    }
}
