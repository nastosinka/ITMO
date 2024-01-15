package itmo.human;

import itmo.lib.Turnable;
import itmo.location.Location;

import java.util.Objects;

public abstract class Human implements Turnable {
    final String name;
    private Location location; 
    private int age;
    private boolean isOnLand;
    public Human(String name, int age, boolean isOnLand, Location location) {
        this.name = name;
        this.age = age;
        this.isOnLand = isOnLand;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }
    public boolean getOnTheGround() {
        return this.isOnLand;
    }
    public void setOnTheGround(boolean isOnLand) {
        this.isOnLand = isOnLand;
    }
    public int getAge() {
        return this.age;
    }
    public String turning() {
        return (getName() + " сделал резкий вираж");
    }
    public Location getLocation() {
        return this.location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "В локации " + getLocation() + " находится " + getName();
    }
    @Override
    public boolean equals(Object o) { // не могу, потому что есть вариант  подлачи другого объекта
        if (o == null || this.getClass() != o.getClass()) return false; // сравниванию классы
        Human human = (Human) o; // привожу к типу Human
        return age == human.age && isOnLand == human.isOnLand && Objects.equals(name, human.name) && location == human.location; // перебираю поля
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, location, age, isOnLand);
    }
}




