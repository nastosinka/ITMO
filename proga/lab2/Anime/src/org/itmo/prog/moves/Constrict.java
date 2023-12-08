package org.itmo.prog.moves;

import ru.ifmo.se.pokemon.*;

import java.lang.Math;

public class Constrict extends PhysicalMove {
    public Constrict () {
        super(Type.NORMAL, 10, 1);
    }
    @Override
    protected void applyOppEffects(Pokemon opp) {
        if (Math.random() < 0.1) {
            opp.addEffect(new Effect().stat(Stat.SPEED, -1));
        }
    }
    @Override
    protected String describe() {
        return "Constrict! Тыдыщ!!";
    }

}
