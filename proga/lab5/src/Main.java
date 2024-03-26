
import java.util.*;
import java.io.*;


import Exceptions.IncorrectCommand;
import Exceptions.NoFileName;



/*
Таски:

1. Почитать про Comparable и ещё какую-то штуку - сортировка
4. Написать интерфейс исполнения команды
5. Написать проверку на корректность csv файла. Разделитель - "точка с запятой"
6. сделать парсинг хумана (csv) в массив со строками, причём автоматически генерить айди (через
итерацию), добавлять null объект
7.
 */


// done через map переделать словарь с командами по индексам, через getkey
// done делить на пробелмы и получать массив строк /
// хуман как база данных
// запарсить csv в экземпляр класса humanbeing, сделать запрет на разделитель
// можно проверить csv на парвильность: если всё ок, то весь сразу записывать
// пкстая строка =  null обхект

public class Main {
    public static void main(String[] args) throws NoFileName, IOException { //по первому индексу обратиться к названию файла

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

        // разобраться, почему файл не читаеттся
        // написать сортировку через comparable и сделать проверку csv на корректнрость
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        while (i != -1) {
            result.add(String.valueOf((char)i));
            i = fr.read();
        }
        System.out.println(result);
        System.out.println(2345);

        // что с помощью comparable сортировать?..
        String now = "";

        //работаем со словарём
        HashMap<String, String> commandArray = new HashMap<>(); // список доступных команд
        commandArray.put("add", "add");
        commandArray.put("help", "help");
        commandArray.put("clear", "clear");
        commandArray.put("exit", "exit");

        while ((!Objects.equals(now, "exit")) && (!now.equals(" "))) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите команду: ");
            String current = in.nextLine(); // читаем строку в current
            String[] commandLine = current.split(" "); // разбиваем строку по разделителю
            now = current; // для проверки завершения команды
            // дообавить массив, который будет заполняться - каждый новый элемент - новая строка в консоли
            try {
                if (commandArray.containsKey(commandLine[0])) { // проверка наличия в словаре
                    System.out.println("najdeno");

                    // прописать вызов команды в зависимости от ключа



                } else {
                    throw new IncorrectCommand("Неверная команда. Попробуйте ещё раз.");
                }
            }
            catch (IncorrectCommand e) {
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