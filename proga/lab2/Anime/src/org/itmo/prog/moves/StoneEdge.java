package org.itmo.prog.moves;

import ru.ifmo.se.pokemon.*;
import org.itmo.prog.pokemony.*;

public class StoneEdge extends PhysicalMove {
    public StoneEdge() {
        super(Type.ROCK, 100, 0.8);
    }

    @Override
    protected double calcCriticalHit(Pokemon var1, Pokemon var2) {
        if (var1.getStat(Stat.SPEED) / 256.0 > Math.random()) {
            System.out.println("Критический удар!1!!");
            return 2.0;
        } else {
            return 1.0;
        }
    }

    @Override
    protected String describe() {
        return "Stone edge! Stoneeees!";
    }
}
