package org.itmo.prog.moves;

import ru.ifmo.se.pokemon.*;

public class HeadSmash extends PhysicalMove {
    public HeadSmash () {
        super(Type.ROCK, 150, 0.8);
    }
    @Override
    protected String describe() {
        return "HeadSmash! Получай!";
    }
    @Override
    protected void applySelfDamage(Pokemon p, double d) {
        p.setMod(Stat.HP, (int) (d * 0.5));
    }
    }
