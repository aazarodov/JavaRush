package com.javarush.test.level17.lesson10.bonus01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String command = "", name = "", sex = "";
        int id = -1, index = 0;
        Date bd = null;

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        if (args.length > 0) {
            command = args[0];
            switch (command) {
                case "-c":
                    {
                        index = 1;
                        name = args[index++];
                        for (int i = index; i < args.length; i++) {
                            if (args[i].equals("м") || args[i].equals("ж")) {
                                sex = args[i];
                                index = i + 1;
                                break;
                            }
                            else
                                name += " " + args[i];
                        }
                        bd = format.parse(args[index]);
                        if (sex.equals("м"))
                            allPeople.add(Person.createMale(name, bd));
                        else if (sex.equals("ж"))
                            allPeople.add(Person.createFemale(name, bd));
                        System.out.println(allPeople.size() - 1);
                    } break;
                case "-u":
                    {
                        index = 1;
                        id = Integer.parseInt(args[index++]);
                        name = args[index++];
                        for (int i = index; i < args.length; i++) {
                            if (args[i].equals("м") || args[i].equals("ж")) {
                                sex = args[i];
                                index = i + 1;
                                break;
                            }
                            else
                                name += " " + args[i];
                        }
                        bd = format.parse(args[index]);
                        Sex s = null;
                        if (sex.equals("м"))
                            s = Sex.MALE;
                        else if (sex.equals("ж"))
                            s = Sex.FEMALE;

                        Person p = allPeople.get(id);
                        p.setName(name);
                        p.setSex(s);
                        p.setBirthDay(bd);
                    } break;
                case "-d":
                    {
                        id = Integer.parseInt(args[1]);
                        Person p = allPeople.get(id);
                        p.setName(null);
                        p.setSex(null);
                        p.setBirthDay(null);
                    } break;
                case "-i":
                    {
                        id = Integer.parseInt(args[1]);
                        Person p = allPeople.get(id);
                        Sex s = p.getSex();
                        String str = "";
                        if (s.equals(Sex.MALE))
                            str = "м";
                        else if (s.equals(Sex.FEMALE))
                            str = "ж";
                        System.out.println(p.getName() + " " + str + " " + dateFormat.format(p.getBirthDay()));
                    } break;
            }
        }
    }
}
