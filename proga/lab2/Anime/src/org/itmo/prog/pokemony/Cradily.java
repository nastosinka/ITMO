package org.itmo.prog.pokemony;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import org.itmo.prog.moves.*;

public class Cradily extends Lileep {
    public Cradily(String name, int level) {

        super(name, level);
        setStats(86, 81, 97, 81, 107, 43);
        setLevel(level);
        addMove(new Bulldoze());

    }
}
