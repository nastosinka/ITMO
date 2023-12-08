package org.itmo.prog.moves;

import org.itmo.prog.pokemony.*;

import ru.ifmo.se.pokemon.*;

public class Growl extends StatusMove {
    public Growl() { super(Type.NORMAL, 0, 1);}
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().stat(Stat.ATTACK, -1));
    }
    @Override
    protected String describe() {
        return "Growl!";
    }
}