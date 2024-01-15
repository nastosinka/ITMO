package itmo.location;

import itmo.human.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;



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

   

