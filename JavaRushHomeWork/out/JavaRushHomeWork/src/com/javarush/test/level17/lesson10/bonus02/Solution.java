package com.javarush.test.level17.lesson10.bonus02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        try {
            chooseCommand(args);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Choose command
    private static void chooseCommand(String[] args) throws ParseException {
        if (args.length > 0) {
            String command = args[0];
            switch (command) {
                case "-c":
                    addPeople(args);
                    break;
                case "-u":
                    updatePeople(args);
                    break;
                case "-d":
                    logicalDeletePeople(args);
                    break;
                case "-i":
                    printPeople(args);
                    break;
            }
        }
    }

    // Command -с
    private static void addPeople(String[] args) throws ParseException {
        int index = 1;
        while (index < args.length - 1) {
            String name = args[index++], sex = "";
            for (int i = index; i < args.length; i++) {
                if (args[i].equals("м") || args[i].equals("ж")) {
                    sex = args[i];
                    index = i + 1;
                    break;
                } else
                    name += " " + args[i];
            }
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date bd = format.parse(args[index++]);
            if (sex.equals("м"))
                allPeople.add(Person.createMale(name, bd));
            else if (sex.equals("ж"))
                allPeople.add(Person.createFemale(name, bd));
            System.out.println(allPeople.size() - 1);
        }
    }

    // Command -u
    private static void updatePeople(String[] args) throws ParseException {
        int index = 1;
        while (index < args.length - 1) {
            int id = Integer.parseInt(args[index++]);
            String name = args[index++], sex = "";
            for (int i = index; i < args.length; i++) {
                if (args[i].equals("м") || args[i].equals("ж")) {
                    sex = args[i];
                    index = i + 1;
                    break;
                } else
                    name += " " + args[i];
            }
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date bd = format.parse(args[index++]);
            Sex s = null;
            if (sex.equals("м"))
                s = Sex.MALE;
            else if (sex.equals("ж"))
                s = Sex.FEMALE;
            Person p = allPeople.get(id);
            p.setName(name);
            p.setSex(s);
            p.setBirthDay(bd);
        }
    }

    // Command -d
    private static void logicalDeletePeople(String[] args) throws ParseException {
        int id;
        for (int i = 1; i < args.length; i++) {
            id = Integer.parseInt(args[i]);
            Person p = allPeople.get(id);
            p.setName(null);
            p.setSex(null);
            p.setBirthDay(null);
        }
    }

    // Command -i
    private static void printPeople(String[] args) throws ParseException {
        int id;
        for (int i = 1; i < args.length; i++) {
            id = Integer.parseInt(args[i]);
            Person p = allPeople.get(id);
            Sex s = p.getSex();
            String str = "";
            if (s.equals(Sex.MALE))
                str = "м";
            else if (s.equals(Sex.FEMALE))
                str = "ж";
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(p.getName() + " " + str + " " + dateFormat.format(p.getBirthDay()));
        }
    }
}
