package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grandDad1 = new Human("Вася", true, 67);
        Human grandDad2 = new Human("Петя", true, 62);

        Human grandBa1 = new Human("Катя", false, 71);
        Human grandBa2 = new Human("Лена", false, 69);

        Human father = new Human("Толя", true, 45, grandDad1, grandBa1);
        Human mother = new Human("Света", false, 42, grandDad2, grandBa2);

        Human son = new Human("Коля", true, 21, father, mother);
        Human dauther1 = new Human("Оля", false, 18, father, mother);
        Human dauther2 = new Human("Юля", false, 15, father, mother);

        System.out.println(grandDad1);
        System.out.println(grandBa1);
        System.out.println(grandDad2);
        System.out.println(grandBa2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son);
        System.out.println(dauther1);
        System.out.println(dauther2);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
        Human(String name, Boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        Human(String name, Boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setSex(Boolean sex) {
            this.sex = sex;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public void setFather(Human father) {
            this.father = father;
        }
        public void setMother(Human mother) {
            this.mother = mother;
        }
    }

}
