package org.itmo.prog.moves;

import ru.ifmo.se.pokemon.*;

import org.itmo.prog.pokemony.*;

public class ShellSmash extends StatusMove {
    public ShellSmash() {
        super(Type.NORMAL, 0, 0); //так как не указаны в каталоге
    }

    @Override //снижает защиту и специальную защиту пользователя
    protected void applySelfEffects(Pokemon p) {// но повышает атаку, спец.атаку и скорость +2
        Effect e = new Effect().stat(Stat.DEFENSE, -1).stat(Stat.SPECIAL_DEFENSE, -1).stat(Stat.ATTACK, 2).stat(Stat.SPEED, 2).stat(Stat.SPECIAL_ATTACK, 2);
        p.addEffect(e);
    }
    @Override
    protected String describe() {
        return "Использование ShellSmash! Тыдыщ!";
    }
}

