package org.itmo.prog.moves;

import ru.ifmo.se.pokemon.*;

public class Bulldoze extends PhysicalMove {
    public Bulldoze () {
        super(Type.GROUND, 60, 1);
    }
    @Override
    protected void applyOppEffects(Pokemon opp) {
        opp.addEffect(new Effect().stat(Stat.SPEED, -1));
    }
    @Override
    protected String describe() {
        return "Использование навыка 'Bulldoze'";
    }

}