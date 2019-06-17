package ru.geekbrains.lesson_6.animals;

public class Dog extends Animal {

    public Dog (String name){
        super (name);
    }
    @Override
    public void run (double l){
        if (l >= 0 && l <= Math.random()*300 + 200) System.out.println(name + " пробежал " + l + " метров");
        else System.out.println(name + " не может пробежать " + l + " метров");
    }
    @Override
    public void swim (double l){
        if ( l >= 0 && l <=Math.random()*10 + 5) System.out.println(name + " проплыл " + l + " метров");
        else System.out.println(name + " не может проплыть " + l + " метров");
    }
    @Override
    public void jump (double l){
        if (l >= 0 && l <= Math.random()) System.out.println(name + " подпрыгнул на " + l + " метра");
        else System.out.println(name + " не может подпрыгнуть на " + l + " метра");
    }
}
