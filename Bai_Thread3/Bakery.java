package Bai_Thread3;

class Bakery {
    private int breadCount = 0;
    private final int MAX_BREAD = 10;

    public synchronized void produceBread() {
        while (true) {
            while (breadCount >= MAX_BREAD) {
                try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            breadCount++;
            System.out.println("Sản xuất bánh: " + breadCount);
            notifyAll();
            try { Thread.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    public synchronized void consumeBread(String customer) {
        while (true) {
            while (breadCount == 0) {
                System.out.println(customer + " đến nhưng không có bánh để mua!");
                return;
            }
            System.out.println(customer + " mua 1 cái bánh. Còn lại: " + --breadCount);
            notifyAll();
            try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
