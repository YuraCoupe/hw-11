package ua.goit.javacore4.HW11;

import java.util.List;

public class Race {
    private int distance;
    private int finishPlace = 0;
    private Object monitor = new Object();

    public Race(int distance) {
        this.distance = distance;
    }

    public void startRace(List<Car> cars) {
        for (Car car : cars) {
            createThreadCar(car);
        }

    }

    private void createThreadCar(Car car) {
        new Thread(() -> {
            while (car.getPassedDistance() < distance) {
                car.setPassedDistance(car.getPassedDistance() + car.getMaxSpeed());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (car.getPassedDistance() >= distance) {
                    synchronized (monitor) {
                        finishPlace++;
                        System.out.println("Car " + car.getName() + ", finishPlace " + finishPlace);
                    }
                }
            }
        }).start();
    }
}
