package ua.goit.javacore4.HW11;

public class Car {
    private String name;
    private int maxSpeed;
    private int passedDistance;

    public Car(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.passedDistance = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getPassedDistance() {
        return passedDistance;
    }

    public void setPassedDistance(int distance) {
        this.passedDistance = distance;
    }
}
