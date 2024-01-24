package itmo.human;

import itmo.exceptions.TwoWorlds;
import itmo.exceptions.WrongLocationException;
import itmo.lib.Knowledgeable;
import itmo.lib.Laughtable;
import itmo.lib.StickableOut;
import itmo.lib.Ununderstandable;
import itmo.location.Location;

import java.util.Objects;

public class Malysh extends Human implements Ununderstandable, Knowledgeable, StickableOut, Laughtable {

    private String objectWithMalysh; // какой-то объект, который есть у Малыша
    static boolean instanced = false;
    public Malysh (String name, int age, boolean isOnLand, String objectWithMalysh, Location location) {
        super(name, age, isOnLand, location); // наследуемся от родителя
        if (instanced) {
            throw new TwoWorlds();
        }
        this.objectWithMalysh = objectWithMalysh; // устанавливаем объект с Малышом
        changeItem(new Item(getObjectWithMalysh(), "сосётся сильнее, чем на американских горках") { // анонимный класс
            @Override
            public String use() {
                return getObjectWithMalysh() + ", которая " + getUsage() + ".";
            }
        });
        instanced = true;
    }
    public String getObjectWithMalysh() {
        return objectWithMalysh;
    }
    public String buzzing() { // звенит в ушах, если на земле
        if (isOnTheGround()) {
            return ("У " + getName() + "а зазвенело в ушах.");
        } else {
            return ("У " + getName() + "а не зазвенело в ушах.");
        }
    }
    public String holding() {// вещь с Малышом
        return ("У " + getName() + "а есть " + getItem().getItemName() + ". ");
    }
    public String ringTheDoorbell() throws WrongLocationException {
        if (getLocation() != Location.BLACK_EXIT) {
            throw new WrongLocationException(this, Location.BLACK_EXIT);
        }
        return (getName() + " трезвонил у двери чёрного хода что было сил.");
    }
    public String hearTheSteps() {
        return (getName() + " услышал приближающиеся шаги и бросился бежать.");
    }
    public String hideNearTheLocation() {
        return getName() + " прятался на " + getLocation() + "e. ";
    }
    @Override
    public String laughting() {
        return getName() + " смеялся.";
    }
    @Override
    public String ununderstanding() { // непонимание
        return (getName() + " ничего не успел понять.");
    }
    @Override
    public String stickingOut() {
        return getName() + " высунул шею за угол. ";
    }
    @Override
    public String toString() { // переопределяем вывод объекта
        return "В локации " + getLocation() + " находится " + getName() + ", у него имеется " + getItem().getItemName() + ".";
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

    @Override
    public String knowing() {
        return getName() + " это знал: ";
    }
//    public void testKnowing() {
//        if (this.getClass().getInterfaces()) {
//
//        }
//    }
    // придумать как зафигать проверяемый через интерфейсы и РЕФЛЕКСИЮ??????
}

