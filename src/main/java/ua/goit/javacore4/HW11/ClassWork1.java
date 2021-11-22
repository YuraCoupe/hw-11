package ua.goit.javacore4.HW11;

import java.util.ArrayList;
import java.util.List;

public class ClassWork1 {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Mercedes", 250));
        cars.add(new Car("BMW", 280));
        cars.add(new Car("Audi", 230));
        cars.add(new Car("Porsche", 330));
        cars.add(new Car("Lexus", 180));
        Race race = new Race(2000);
        race.startRace(cars);
    }
}
