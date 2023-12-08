package org.itmo.prog.pokemony;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import org.itmo.prog.moves.*;

public class Lileep extends Pokemon {

    public Lileep(String name, int level) {

        super(name, level);
        setStats(66, 41, 77, 61, 87, 23);
        setLevel(level);
        setType(Type.ROCK, Type.GRASS);
        setMove(new Constrict(), new RockPolish(), new GigaDrain());

    }
}
