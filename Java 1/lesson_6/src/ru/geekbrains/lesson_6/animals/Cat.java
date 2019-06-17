package ru.geekbrains.lesson_6.animals;

public class Cat extends Animal {

    public Cat (String name){
       super (name);
    }
    @Override
    public void run (double l){
        if (l >= 0 && l <= (Math.random()*200) + 100) System.out.println(name +  " пробежал " + l + " метров");
        else System.out.println(name + " не может пробежать " + l + " метров");
    }
    @Override
    public void swim(double l){

        System.out.println("Кот не умеет плавать");
    }
    @Override
    public void jump (double l){
        if (l >= 0 && l <= Math.random() + 1 ) System.out.println(name + " подпрыгнул на " + l + " метра");
        else System.out.println(name + " не может подпрыгнуть на " + l + " метра");

    }
}
