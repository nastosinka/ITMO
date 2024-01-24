package itmo.human;

import itmo.exceptions.HeroNotBornYet;
import itmo.lib.Turnable;
import itmo.location.Location;

import java.util.Objects;

public abstract class Human implements Turnable {
    // есть какой-то абстрактный item, который каждый определяем, как хочет.
    // у него есть только 2 обязательных для определения поля и 1 метод: name, usage и use().
    // имеется конструктор по полям, геттеры на оба поля
    public static abstract class Item { // абстрактный вложенный класс
        private final String name; // название предмета
        private String usage;
        public abstract String use(); // исопльзование предмета / надо будет потом определить!!!!
        public String getItemName() {return name;}
        public String getUsage() { return usage;}
        public Item(String name, String usage) {
            this.name = name;
            this.usage = usage;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return Objects.equals(name, item.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public void changeItem(Item newItem) { // так как статичный Item
        item = newItem;
    }

    public Item getItem() {
        return item;
    }

    private Item item; // хранит в себе экземпляр айтима, поле
    private final String name;
    private Location location; // создаём локацию зачем блин???
    private final int age;
    private boolean isOnLand;
    public Human(String name, int age, boolean isOnLand, Location location) {
        if (name.isBlank() || name == null) {
            throw new NullPointerException("Пустое имя");
        }
        // age и остальное примитивы, там приколов быть не должно
        this.name = name;

        if (age < 0) {
            throw new HeroNotBornYet(this);
        }

        this.age = age;
        this.isOnLand = isOnLand;

        if (location == null) {
            throw new NullPointerException("Пустой location");
        }

        this.location = location;
    }

    public String getName() {
        return this.name;
    }
    public boolean isOnTheGround() {
        return this.isOnLand;
    }
    public void setOnTheGround(boolean isOnLand) {
        this.isOnLand = isOnLand;
    }
    public int getAge() {
        return this.age;
    }
    public String turning() {
        return ("Персонаж " + getName() + " сделал резкий вираж.");
    }
    public Location getLocation() {
        return this.location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "В локации " + getLocation() + " находится " + getName() + ".";
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

