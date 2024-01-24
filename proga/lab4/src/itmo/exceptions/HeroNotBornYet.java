package itmo.exceptions;

import itmo.human.Human;

public class HeroNotBornYet extends RuntimeException {
    public HeroNotBornYet(Human hero) {
        super(hero.getName() + " ещё не родился...");
    }
}
