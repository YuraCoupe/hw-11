package ua.goit.javacore4.HW11;

public class Timer {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {

        int timer = 0;

        Thread fiveSecondsTimer = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    try {
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("5 seconds passed");
            }
        });
        fiveSecondsTimer.start();

        while (true) {
            if (timer % 5 != 0) {
                System.out.println(timer);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer++;
            if (timer % 5 == 0) {
                synchronized (MONITOR) {
                    MONITOR.notify();
                }
            }
        }
    }
}
