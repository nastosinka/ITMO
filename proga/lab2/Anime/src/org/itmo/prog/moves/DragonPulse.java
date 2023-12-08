package org.itmo.prog.moves;

import ru.ifmo.se.pokemon.*;

public class DragonPulse extends SpecialMove {
    public DragonPulse() {
        super(Type.DRAGON, 85, 1);
    }
    @Override
    protected String describe() {
        return "Познакомься с моим DragonPulse!";
    }
}
