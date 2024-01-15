package itmo.human;

import itmo.lib.Ununderstandable;
import itmo.location.Location;

import java.util.Objects;

public class Malysh extends Human implements Ununderstandable {

    protected String objectWithMalysh; // какой-то объект, который есть у Малыша

    public Malysh (String name, int age, boolean isOnLand, String objectWithMalysh, Location location) {
        super(name, age, isOnLand, location); // наследуемся от родителя
        this.objectWithMalysh = objectWithMalysh; // устанавливаем объект с Малышом
    }
    public void setObjectWithMalysh(String ObjectWithMalysh) {
        this.objectWithMalysh = ObjectWithMalysh; // сеттер для объекта
    }
    public String getObjectWithMalysh() {
        return this.objectWithMalysh; // геттер для объекта
    }
    public String buzzing() { // звенит в ушах, если на земле
        if (getOnTheGround()) {
            return ("У " + getName() + "а зазвенело в ушах");
        } else {
            return ("У " + getName() + "а не зазвенело в ушах");
        }
    }
    public String holding() {// вещь с Малышом
        return (getName() + " имеет при себе " + getObjectWithMalysh());
    }
    public String ununderstanding() { // непонимание
        return (getName() + " не успел опомниться");
    }
    @Override
    public String toString() { // переопределяем вывод объекта
        return "В локации " + getLocation() + " находится " + getName() + ", у него имеется " + getObjectWithMalysh();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false; // сравнивает родительские поля (которые были до этого)
        Malysh malysh = (Malysh) o;
        return Objects.equals(objectWithMalysh, malysh.objectWithMalysh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), objectWithMalysh);
    }
}

