package org.itmo.prog.pokemony;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import org.itmo.prog.moves.*;

public class Nidoqueen extends Nidorina {
    public Nidoqueen(String name, int level) {

        super(name, level);
        setStats(90, 92, 87, 75, 85, 76);
        setLevel(level);
        addMove(new StoneEdge());
        addType(Type.GROUND);

    }
}
