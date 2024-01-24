package itmo.human;

import itmo.exceptions.TwoWorlds;
import itmo.lib.StickableOut;
import itmo.location.Location;

import java.util.Objects;

public class FrokenBock extends Human implements StickableOut {
    private Occupation occupation; // создаём поле класса профессии
    static boolean instanced = false;
    public class Occupation { // вложенный класс профессия
        private final String description;

        public String getDescription() {
            return description;
        }

        public String performWorkDuties() {
            return getName() + " выполняет должностные обязанности.";
        }
        public Occupation (String occupationDescription) {
            this.description = occupationDescription;
        }
    }
    public FrokenBock(String name, int age, boolean isOnIsland, Location location) {
        super(name, age, isOnIsland, location);
        if (instanced) {
            throw new TwoWorlds();
        }

         occupation = new Occupation("домработница"); // инициировали вложенный класс
        instanced = true;
    }
    public Occupation getOccupation() {
        return occupation;
    }
    public String beGreen() {
        return getName() + " позеленела от бешенства.";
    }
    public String scold() {
        return getName() + " бронилась что есть сил.";
    }
    public String standingInLocation() {
        return getName() + " долго стояла у " + getLocation() + " и ждала кого-то.";
    }
    @Override
    public String stickingOut() {
        return getName() + " высунула голову за угол.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FrokenBock that = (FrokenBock) o;
        return Objects.equals(occupation, that.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), occupation);
    }
}
