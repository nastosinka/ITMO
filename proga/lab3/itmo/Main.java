package itmo;

import itmo.human.Karlson;
import itmo.human.Malysh;
import itmo.location.Location;
import itmo.location.Surrounding;


public class Main {
    static Malysh malysh = new Malysh("Малыш", 8, true, "ложечка", Location.ROOM);
    static Karlson karlson = new Karlson("Карлсон", 29, true, true, Location.ROOM);
    static Surrounding surrounding = new Surrounding(karlson, malysh);

    public static void main(String[] args) {

        System.out.println(surrounding.getSurrounding());

        System.out.println(karlson.say()); // Карлсон сказал, как всё произойдёт
        System.out.println(karlson.sigh()); // Карлсон вздохнул
        System.out.println(malysh.ununderstanding()); // Малыш не успел опомниться
        System.out.println(karlson.flying()); // Карлсон полетел
        System.out.println(karlson.turning()); // Карлсон сделал резкий вираж
        System.out.println(malysh.turning()); // Малыш сделал резкий вираж
        System.out.println(malysh.buzzing()); // У Малыша загудело в ушах
        System.out.println(malysh.holding()); // У Малыша есть ложечка;


        karlson.setOnTheGround(false);
        malysh.setOnTheGround(false);
        karlson.setLocation(Location.BALKON);
        malysh.setLocation(Location.BALKON);

        System.out.println(surrounding.getSurrounding());
     

    }
}
