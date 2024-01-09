package human;

import lib.Ununderstandable;
import location.Location;

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
}

