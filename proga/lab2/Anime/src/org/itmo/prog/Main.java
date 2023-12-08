package org.itmo.prog;

import ru.ifmo.se.pokemon.Battle; //импортируем классы из jar
import ru.ifmo.se.pokemon.Pokemon; //импортируем покемона для тестового боя

import org.itmo.prog.pokemony.*; //импортируем покемонов

import java.net.NetworkInterface;

public class Main {

    // https://pokemondb.net/pokedex/togedemaru
    // https://pokemondb.net/pokedex/lileep
    // https://pokemondb.net/pokedex/cradily
    // https://pokemondb.net/pokedex/nidoran-f
    // https://pokemondb.net/pokedex/nidorina
    // https://pokemondb.net/pokedex/nidoqueen

    public static void main(String[] args) {

        Battle b = new Battle(); //начинаем новую битву
        Togedemaru p1 = new Togedemaru("Покемон", 1); //создаём первого покемона
        Lileep p2 = new Lileep("Покемон", 1);
        Cradily p3 = new Cradily("Покемон", 1);
        Nidoqueen p4 = new Nidoqueen("Покемон", 1);
        Nidorina p5 = new Nidorina("Покемон", 1);
        NidoranF p6 = new NidoranF("Покемон", 1);

        b.addAlly(p1);
        b.addAlly(p4);
        b.addAlly(p3);

        b.addFoe(p2);
        b.addFoe(p5);
        b.addFoe(p6);

        b.go();

    }
}

