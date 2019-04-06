package ru.geekbrains.lesson_7;

public class Main {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat ("Пушистик", 7),
                new Cat ("Васька", 10),
                new Cat ("Рыжик", 12),
                new Cat ("Мурзик", 11),
        } ;
        Plate plate = new Plate(30);
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cats[i].checkSatiety();
            System.out.println(plate.toString());
            System.out.println();

            if (!cats[i].getSatiety()) {
                plate.increaseFood(30);
                cats[i].eat(plate);
                cats[i].checkSatiety();
                System.out.println(plate.toString());
                System.out.println();
            }
        }


    }

}
