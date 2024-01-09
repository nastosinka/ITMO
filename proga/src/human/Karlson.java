package human;

import lib.Flyable;
import location.Location;

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

}