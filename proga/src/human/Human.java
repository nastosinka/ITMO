package human;

import lib.Turnable;
import location.Location;

public abstract class Human implements Turnable {
    final String name;
    private Location location; // создаём локацию зачем блин???
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
    public int hashCode() {
        return getName().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass())
            return true;
        return obj.hashCode() == this.hashCode();
    }
    @Override
    public String toString() {
        return "В локации " + getLocation() + " находится " + getName();
    }
}





    /*
    final String locations;
    public Arounding (String locations, boolean changing);
        this.changing = changing;
    }
    @Override
    public int hashCode() {
        return getName().hashCode();
    }
    @Override
    public boolean equals(Object obj) { //потому что все последующие классы наследуюься
        if (this.getClass() != obj.getClass()) // применяется к текущему
            return false; // возвращает значение
        return obj.hashCode() == this.hashCode();
    }
    @Override
    public String toString() {
        return "Существо по имени " + getName();
    }
        };
    }
}
*/