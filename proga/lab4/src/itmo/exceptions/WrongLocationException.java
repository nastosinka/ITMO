package itmo.exceptions;

import itmo.location.Location;
import itmo.human.Human;

public class WrongLocationException extends Exception {

    public WrongLocationException(Human human, Location locationThatShouldBeIn) {
        super("!!!" + human.getName() + " должен находится в " + locationThatShouldBeIn + "!!!");
    }
}
