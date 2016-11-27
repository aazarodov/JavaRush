package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grandfatherOne = new Human("Коля", true, 75);
        Human grandfatherTwo = new Human("Петя", true, 72);

        Human grandmotherOne = new Human("Надя", false, 70);
        Human grandmotherTwo = new Human("Света", false, 71);

        Human father = new Human("Вася", true, 45);
        Human mother = new Human("Оля", true, 40);

        grandfatherOne.addChild(mother);
        grandmotherOne.addChild(mother);

        grandfatherTwo.addChild(father);
        grandmotherTwo.addChild(father);

        Human childOne = new Human("Юля", false, 15);
        Human childTwo = new Human("Вера", false, 18);
        Human childThree = new Human("Вова", true, 20);

        father.addChild(childOne);
        father.addChild(childTwo);
        father.addChild(childThree);

        mother.addChild(childOne);
        mother.addChild(childTwo);
        mother.addChild(childThree);

        System.out.println(grandfatherOne);
        System.out.println(grandmotherOne);

        System.out.println(grandfatherTwo);
        System.out.println(grandmotherTwo);

        Iterator<Human> iterator = grandfatherOne.children.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator = grandfatherTwo.children.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator = father.children.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        List<Human> children = new ArrayList<Human>();

        Human() {};
        Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public void addChild(Human child) {
            this.children.add(child);
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
