package Bai_Thread02;

class TicketCounter {
    private int tickets = 50; // Giả sử có 50 vé để bán


    public synchronized void sellTicket(String station) {
        if (tickets > 0) {
            System.out.println(station + " bán vé số: " + tickets);
            tickets--;
        } else {
            System.out.println(station + " thông báo: Hết vé!");
        }

    }
}
