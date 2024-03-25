
import java.util.LinkedList;
import java.io.*;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Scanner;


import Exceptions.IncorrectCommand;
import Exceptions.NoFileName;



/*
Таски:

1. Почитать про Comparable и ещё какую-то штуку - сортировка
2. Нагенерить CSV
3. Паттеры команд - команды через словарь и ключи реализовывать через хэшмап массив
4. Написать интерфейс исполнения команды
5.
 */


// через map переделать словарь с командами по индексам, через getkey
// делить на пробелмы и получать массив строк /
// хуман как база данных
// можно использовать для истории очередь
// запарсить csv в экземпляр класса humanbeing, сделать запрет на разделитель
// можно проверить csv на парвильность: если всё ок, то весь сразу записывать
// пкстая строка =  null обхект

public class Main {
    public static void main(String[] args) throws NoFileName, IOException, IncorrectCommand { //по первому индексу обратиться к названию файла

        // эксепшн на неуказанное имя файла
        System.out.println();
        if (args.length == 0) {
            throw new NoFileName("Не указано имя файла");
        }

        // выводим название файла и создаём переменную с названием файла
        System.out.printf("Название файла: %s \n", args[0]);
        String currentFile = args[0];
        FileReader fr = new FileReader(currentFile);  // читаем файл в переменную fr
        PrintWriter pw = new PrintWriter(currentFile);   // открываем файл для записи

        // что с помощью comparable сортировать?..
        String now = "";
        LinkedList<String> commandLine = new LinkedList<String>(); // класс, коллекцией которого управляет программа
        LinkedList<String> commandArray = new LinkedList<String>(); // список доступных команд
        commandArray.add("help");
        commandArray.add("add");
        commandArray.add("clear");
        commandArray.add("exit");


        while ((!Objects.equals(now, "exit")) && (now != null) && (!now.equals(" "))) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите команду: ");
            String current = in.nextLine(); // читаем строку в current
            commandLine.add(current);// добавили в "историю" введённую команду
            now = current; // для проверки завершения команды
            // дообавить массив, который будет заполняться - каждый новый элемент - новая строка в консоли
            try {
                ListIterator<String> itr = commandArray.listIterator(); // добавляем итератор
                System.out.println(commandArray.size());
                while (itr.hasNext()) {
                    if (commandArray.contains(current)) {
                        System.out.println("najdeno");
                    } else {
                        // изменить тип ошибки и выкидывать не рантайм, а try-catch
                        throw new IncorrectCommand("Неверная команда. Попробуйте ещё раз.");
                    }
                }
            } catch (IncorrectCommand e) {
                    System.out.println(e.getMessage());
                }
            }


        fr.close();
        pw.close();

    }
}

// что значит сортирует в условии? - comparable интерфейс реализовать (?)

// где достать csv? сгенерить, разделители запятыми и т.д. можно использовать библиотеки для считывания

// считывает файл и каждую строчку в отдельный экземпляр класса

// все классы, что есть, запихать в один файл csv: просто ставить null там, где чего-то нет
// 