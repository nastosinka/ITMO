package org.itmo.prog.pokemony;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

import org.itmo.prog.moves.*;

public class Togedemaru extends Pokemon {

    public Togedemaru(String name, int level) {

        super(name, level); // позволяет использовать параметры при вызове родительского метода
        setStats(65, 98, 63, 40, 73, 96); //устанавливаем его стату
        setLevel(level); //говорим, что его уровень - тот, что указан при вызове
        setType(Type.ELECTRIC, Type.STEEL); // задаём ему типы
        setMove(new DragonPulse(), new ShellSmash(), new HeadSmash(), new DoubleTeam()); // устанавливаем атаки

    }
}
