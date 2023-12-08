package org.itmo.prog.moves;

import ru.ifmo.se.pokemon.*;

import java.lang.Math;

public class IceBeam extends SpecialMove {
    public IceBeam() {
        super(Type.ICE, 90, 1);
    }
    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.1) {
            Effect e = new Effect().condition(Status.FREEZE);
            p.setCondition(e);
        }
    }
    @Override
    protected String describe() {
        return "IceBeam! Лёд-лёд-лёд!";
    }
}