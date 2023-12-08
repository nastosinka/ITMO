package org.itmo.prog.pokemony;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import org.itmo.prog.moves.*;

public class NidoranF extends Pokemon {
    public NidoranF(String name, int level) {

        super(name, level);
        setStats(55, 47, 52, 40, 40, 41);
        setLevel(level);
        setType(Type.POISON);
        setMove(new IceBeam(), new Venoshock());

    }
}
