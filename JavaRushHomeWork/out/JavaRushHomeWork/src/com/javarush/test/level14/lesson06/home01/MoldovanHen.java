package com.javarush.test.level14.lesson06.home01;

/**
 * Created by zarodov on 31.08.2016.
 */
public class MoldovanHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return 5;
    }

    public String getDescription(){
        return super.getDescription() + " Моя страна - "+ Country.MOLDOVA+ ". Я несу " + getCountOfEggsPerMonth() +" яиц в месяц.";
    }
}
