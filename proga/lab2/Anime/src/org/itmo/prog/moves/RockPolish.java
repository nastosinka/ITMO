package org.itmo.prog.moves;

import org.itmo.prog.pokemony.*;

import ru.ifmo.se.pokemon.*;

public class RockPolish extends StatusMove {
    public RockPolish() {
        super(Type.ROCK, 0, 0);
    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect e = new Effect().stat(Stat.SPEED, 2);
        p.addEffect(e);
    }
    @Override
    protected String describe() {
        return "RockPolish!";
    }
}