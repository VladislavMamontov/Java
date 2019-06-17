package ru.geekbrains.lesson_6.animals;

public abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void run(double l);

    public abstract void swim(double l);

    public abstract void jump (double l);

}
