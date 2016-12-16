package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public synchronized String toString() {
        return "Name: " + this.name + ", distance: " + this.distance + ", quality: " + this.quality;
    }

    public static void main(String[] args) {
        ArrayList<Beach> listBeach = new ArrayList<Beach>();
        listBeach.add(new Beach("Beach2", 1, 3));
        listBeach.add(new Beach("Beach1", 1, 3));
        listBeach.add(new Beach("Beach1", 2, 1));
        listBeach.add(new Beach("Beach1", 1, 2));
        listBeach.add(new Beach("Beach3", 1, 1));

        for(Beach b : listBeach)
            System.out.println(b);

        System.out.println("------------------------------");

//        for (int i = 0; i < listBeach.size(); i++) {
//            for (int j = 0; j < listBeach.size() - 1; j++) {
//                Beach b = listBeach.get(j);
//                if (b.compareTo(listBeach.get(j + 1)) > 0) {
//                    listBeach.set(j, listBeach.get(j + 1));
//                    listBeach.set(j + 1, b);
//                }
//            }
//        }

        Collections.sort(listBeach);

        for(Beach b : listBeach)
            System.out.println(b);

        System.out.println("------------------------------");

        Beach beach1 = new Beach("beach1", 123.6f, 7);
        Beach beach2 = new Beach("beach2", 124.6f, 8);
        Beach beach3 = new Beach("beach3", 124.6f, 8);
        System.out.println(beach1.compareTo(beach2));
        System.out.println(beach2.compareTo(beach3));
        System.out.println(beach1.compareTo(beach3));
    }

    @Override
    public synchronized int compareTo(Beach o) {
        return (
                this.name.compareTo(o.getName())
                        + 10000 * (this.quality - o.getQuality())
                        + 100 * (int)(this.distance - o.getDistance()));
    }
}
