package itmo;

import itmo.exceptions.WrongLocationException;
import itmo.human.FrokenBock;
import itmo.human.Human;
import itmo.human.Karlson;
import itmo.human.Malysh;
import itmo.location.Location;
import itmo.location.Surrounding;

public class Main {
    static Malysh malysh = new Malysh("Малыш", 8, true, "Ложечка", Location.ROOM);
    static Karlson karlson = new Karlson("Карлсон", 29, true, true, Location.ROOM);
    static FrokenBock frokenBock = new FrokenBock("Фрекен Бок", 55, true, Location.DOOR);
    static Surrounding surrounding = new Surrounding(karlson, malysh, frokenBock);

    public static void main(String[] args) {

        System.out.println(surrounding.getSurrounding());

        class Mama extends Human { // локальный класс
            public Mama(String name, int age, boolean isOnLand, Location location) {
                super(name, age, isOnLand, location);
            }
            String knockOutTheRug() {
                return getName() + " частенько выбивает половик на " + getLocation() + "e.";
            }
        }

        Mama mama = new Mama("Мама", 45, true, Location.BALKON);

        System.out.print(malysh.knowing());
        System.out.println(mama.knockOutTheRug());
        System.out.println(Location.BALKON.getFullDescription());
        System.out.println(karlson.say()); // Карлсон сказал, как всё произойдёт
        System.out.println(malysh.ununderstanding());

        System.out.println(karlson.sigh()); // Карлсон вздохнул
        System.out.println(malysh.ununderstanding()); // Малыш не успел опомниться
        System.out.println(karlson.fly(Location.BALKON)); // Карлсон полетел
        System.out.println(karlson.turning()); // Карлсон сделал резкий вираж
        System.out.println(malysh.turning()); // Малыш сделал резкий вираж
        System.out.println(malysh.buzzing()); // У Малыша загудело в ушах
        System.out.print(malysh.holding()); // У Малыша есть ложечка;
        System.out.println(malysh.getItem().use());
        karlson.setOnTheGround(false);
        malysh.setOnTheGround(false);
        karlson.setLocation(Location.WINDOW);
        malysh.setLocation(Location.BLACK_EXIT);

        System.out.println(surrounding.getSurrounding());

        System.out.println(surrounding.happening(karlson));
        System.out.println(karlson.getItem().use());
        tryRingTheDoorbell();
        System.out.println(malysh.hearTheSteps());
        malysh.setLocation(Location.BALKON);

        System.out.println(surrounding.getSurrounding());

        System.out.println(surrounding.opening(Location.DOOR));
        System.out.println(frokenBock.getOccupation().performWorkDuties());
        System.out.println(frokenBock.stickingOut());
        System.out.println(malysh.stickingOut());
        System.out.print(malysh.knowing());
        System.out.println(karlson.say());
        System.out.print(frokenBock.beGreen());
        System.out.println(frokenBock.scold());
        System.out.println(frokenBock.standingInLocation());
        System.out.print(malysh.hideNearTheLocation());
        System.out.println(malysh.laughting());
        System.out.println(karlson.fly(Location.HOUSE_PORCH));
        karlson.setLocation(Location.HOUSE_PORCH);
        malysh.setLocation(Location.HOUSE_PORCH);

        class Feast {
            private String characteristic;
            public String waitForGuests() {
                return "пир ждал гостей.";
            }
            public String getCharacteristic() {
                return characteristic;
            }
            public Feast(String characteristic) {
                this.characteristic = characteristic;
            }
        }
        Feast feast = new Feast("Лучший ");
        System.out.print(feast.getCharacteristic());
        System.out.println(feast.waitForGuests());

        System.out.println(surrounding.getSurrounding());

    }

    static void tryRingTheDoorbell() {
        try {
            System.out.println(malysh.ringTheDoorbell());
        }
        catch (WrongLocationException e) {
            malysh.setLocation(Location.BLACK_EXIT);
            System.out.println(e.getMessage());
            tryRingTheDoorbell();
        }
    }
}