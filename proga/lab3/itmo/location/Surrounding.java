package itmo.location;

import itmo.human.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 */


public class Surrounding { //создаём класс окружения - а-ля сцена театра
    public Surrounding(Human... newSurroundingObjects) {
        for (Human newSurroundingObject : newSurroundingObjects) {
            surrounding.put(newSurroundingObject.getName(), newSurroundingObject);
            flagInitialization = true;
        }
    }
    private HashMap<String, Human> surrounding = new HashMap<>(); // создаём хэшмап для ключей
    static boolean flagInitialization = false;
    public boolean getFlagInitialization() {
        return flagInitialization;
    }

    // создаём добавлятор
    /*
    public void addSurrounding(itmo.human.Human... newSurroundingObjects) {
        for (itmo.human.Human newSurroundingObject : newSurroundingObjects) {
            surrounding.put(newSurroundingObject.getName(), newSurroundingObject);
        }
    }

     */
    public Human getHumanInSurrounding(String name) {
        return surrounding.get(name); // геттер по ключу
    }
    // выводим всё
    public String getSurrounding() { // построчный вывод содержимого значений массива
        String s = "\n";
        ArrayList<Human> values = new ArrayList<>(surrounding.values());
         for (Human i: values) {
            s += i + " \n"; // ура, операции со строками
        }
        return s;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        Surrounding that = (Surrounding) o;
        return Objects.equals(surrounding, that.surrounding);
    }
    @Override
    public int hashCode() {
        return Objects.hash(surrounding);
    }
}

    /*
    Старая реализация:
    public void addHuman(itmo.human.Human... humanity) { // метод добавления к хэшмапу ещё чего-то
        Collections.addAll(humans, humanity); // через коллекции соединяем хуманов и локацию
    }
    public List<itmo.human.Human> getHumans() { // метод возвращения массива хуманов
        return humans;
    }
    <-------------------------------------->
    public void addHuman(itmo.human.Human newHuman) {
        humans.add(newHuman);
    }
    доступ к хэшмап массиву по ключу, но никак не по значению - значения
    могут быть одинаковыми, а ключи всегда разные.

    public void addHuman(itmo.human.Human... newHumans) { // создаём метод добавления хуманов и их приколов
        for (itmo.human.Human newHuman : newHumans) { // добавляем в массив хэшмата путом
            arounding.put(newHuman.getName(), newHuman); // добавляем имя хумана и
        }
    }
    public itmo.human.Human getHumans(String name) { // создаём метод получения информации из хэшмапа
        return arounding.get(name); // в качестве ключа передаём именно имя персонажа
    }
    character - просто имя
     */

