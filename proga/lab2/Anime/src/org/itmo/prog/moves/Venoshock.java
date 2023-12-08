package org.itmo.prog.moves;

import ru.ifmo.se.pokemon.*;

public class Venoshock extends SpecialMove {
    public Venoshock() {
        super(Type.POISON, 65, 1);
    }
    @Override
    protected void applyOppDamage(Pokemon p, double d) {
        if (p.getCondition() == Status.POISON) {
            p.setMod(Stat.HP, (int) (d * 2));
        } else {
            super.applyOppDamage(p, d);
        }
    }
    @Override
    protected String describe() {
        return "Venoshock! Отравление!";
    }
}