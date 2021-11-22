package ua.goit.javacore4.HW11;

public class NumberStringCreator {
    private static final Object MONITOR = new Object();
    private static int marker = 1;


    public static void main(String[] args) {
        int number = 15;
        Thread a = new Thread(() -> fizz(number));
        Thread b = new Thread(() -> buzz(number));
        Thread c = new Thread(() -> fizzbuzz(number));
        Thread d = new Thread(() -> number(number));

        a.start();
        b.start();
        c.start();
        d.start();
    }

    private static void fizz(int number) {
        synchronized (MONITOR) {
            try {
                MONITOR.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(true) {
            if (marker % 3 == 0 & marker % 5 != 0) {
                System.out.print("fizz ");
                synchronized (MONITOR) {
                    marker++;
                    try {
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                synchronized (MONITOR) {
                    MONITOR.notifyAll();
                }
            }
            if (marker > number) {
                break;
            }
        }
    }

    private static void buzz(int number) {
        synchronized (MONITOR) {
            try {
                MONITOR.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(true) {
            if (marker % 5 == 0 & marker % 3 != 0) {
                System.out.print("buzz ");
                synchronized (MONITOR) {
                    marker++;
                    try {
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                synchronized (MONITOR) {
                    MONITOR.notifyAll();
                }
            }
            if (marker > number) {
                break;
            }
        }
    }

    private static void fizzbuzz(int number) {
        synchronized (MONITOR) {
            try {
                MONITOR.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(true) {
            if (marker % 3 == 0 & marker % 5 == 0) {
                System.out.print("fizzbuzz ");
                synchronized (MONITOR) {
                    marker++;
                    try {
                        MONITOR.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                synchronized (MONITOR) {
                    MONITOR.notifyAll();
                }
                if (marker > number) {
                    break;
                }
            }
        }
    }

    private static void number(int number) {
        while(true) {
            if (marker % 3 != 0 & marker % 5 != 0) {
                System.out.print(marker + " ");
                synchronized (MONITOR) {
                    marker++;
                }
            } else {
                synchronized (MONITOR) {
                    MONITOR.notifyAll();
                }
            }
            if (marker > number) {
                break;
            }
        }
    }
}
