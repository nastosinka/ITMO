package org.itmo.prog.moves;

import org.itmo.prog.pokemony.*;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 0);
    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect e = new Effect().stat(Stat.EVASION, 1);
        p.addEffect(e);
    }
    @Override
    protected String describe() {
        return "Doooouble teeeam!";
    }
}
