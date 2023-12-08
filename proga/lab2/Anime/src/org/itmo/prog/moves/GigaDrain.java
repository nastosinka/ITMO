package org.itmo.prog.moves;

import ru.ifmo.se.pokemon.*;

public class GigaDrain extends SpecialMove {
    public GigaDrain() {
        super(Type.GRASS, 75, 1);
    }
    @Override
    protected void applySelfDamage(Pokemon p, double d) {
        p.setMod(Stat.HP, (int) -(d * 0.5)); //изменить на целочисленный, так как в джавадоке он
    }
    @Override
    protected String describe() {
        return "Познакомься с моим GigaDrain!";
    }
}
