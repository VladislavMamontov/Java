package ru.geekbrains.lesson_6;

import ru.geekbrains.lesson_6.animals.Animal;
import ru.geekbrains.lesson_6.animals.Cat;
import ru.geekbrains.lesson_6.animals.Dog;

public class Main {

    public static void main(String[] args) {


        Animal[] animals = {
        new Cat("Борис"),
        new Cat("Мурзик"),
        new Cat("Васька"),
        new Cat("Рыжик"),
        new Dog("Шарик"),
        new Dog("Барбос"),
        new Dog("Рекс"),
        new Dog("Тузик"),
        };

        for (int i = 0; i < animals.length ; i++) {
            animals[i].run(200);
            animals[i].swim(10);
            animals[i].jump(1);
        }
    }
}
