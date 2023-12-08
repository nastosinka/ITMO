package org.itmo.prog.pokemony;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import org.itmo.prog.moves.*;

public class Nidorina extends NidoranF {
    public Nidorina(String name, int level) {

        super(name, level);
        setStats(70, 62, 67, 55, 55, 56);
        setLevel(level);
        addMove(new Growl());

    }
}
