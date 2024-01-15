package itmo.human;

import itmo.lib.Flyable;
import itmo.location.Location;

import java.util.Objects;

public class Karlson extends Human implements Flyable {

    private boolean ventilator; // у Карлсона есть вентилятор

    // конструктор для Карлсона
    public Karlson (String name, int age, boolean isOnLand, boolean ventilator, Location location) {
        super(name, age, isOnLand, location);
        this.ventilator = ventilator;
    }
    public boolean getVentilator() {
        return this.ventilator;
    }
    public String sigh() { // Карлсон вздохнул
        return (getOnTheGround()) ? (getName() + " вздохнул") : ((getName() + " молчит"));
    }
    public String say() { // Карлсон сказал
        return (getName() + " поведал о том, как всё произойдёт");
    }
    public String flying() { // Карлсон полетел
        return (getVentilator()) ? (getName() + " полетел") : ((getName() + " не полетел..."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Karlson karlson = (Karlson) o;
        return ventilator == karlson.ventilator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ventilator);
    }

    public static void main(String[] args) {
        var k1 = new Karlson("", 2, false, true, null);
        var k3 = new Karlson("", 2, false, true, null);
        System.out.println(k1.equals(k3));
        System.out.println(k1.hashCode() == k3.hashCode());
    }

}