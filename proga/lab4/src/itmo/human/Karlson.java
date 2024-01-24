package itmo.human;

import itmo.exceptions.NotStatedThing;
import itmo.exceptions.TwoWorlds;
import itmo.location.Location;

import java.util.Objects;

public class Karlson extends Human {
    static boolean instanced = false;
    public class Ventilator extends Item { // статический вложенный
        public Ventilator() {
            super("Моторчик", "жужжит");
        }
        public String use() {
            return "У " + getName() + "а " + getUsage() + " " + getItemName() + " у " + getLocation() + ".";
        }
    }
    // конструктор для Карлсона
    public Karlson (String name, int age, boolean isOnLand, boolean hasVentilator, Location location) {
        super(name, age, isOnLand, location);
        if (instanced) {
            throw new TwoWorlds();
        }
        if (hasVentilator) {
            changeItem(new Ventilator());
        }
        else {
            throw new NotStatedThing("У карлосона должен быть вентилятор");
        }
        instanced = true;
    } // прописать что если null то runtime выкидывает
    public boolean hasVentilator() {
        if (getItem() == null) {
            throw new NotStatedThing("вы без моторчика:(");
        } else {
            return getItem().getItemName().equals("Моторчик");
        }
    }
    public String sigh() { // Карлсон вздохнул
        return (isOnTheGround()) ? (getName() + " вздохнул.") : ((getName() + " молчит."));
    }
    public String say() { // Карлсон сказал
        return (getName() + " поведал о том, как всё произойдёт.");
    }
    public String fly(Location destination) { // Карлсон полетел
        return (hasVentilator()) ? (getName() + " полетел в пункт назначения " + destination.toString() + ".") : ((getName() + " не полетел..."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Karlson karlson = (Karlson) o;

        if (getItem() == null) {
            return karlson.getItem() == null;
        }
        return getItem().equals(karlson.getItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getItem());
    }

}