package ru.geekbrains.lesson_5;

public class Person {
    private String name;
    private String position;
    private int phoneNumber;
    private int salary;
    private int age;

    public Person (String name, String position, int phoneNumber, int salary, int age){
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info(){
        System.out.println("Имя: " + name + " Должность: " + position + " Тел.номер: " + phoneNumber +
                " Зарплата: " + salary + " Возраст: " + age);
    }

    public int getAge() {
        return age;
    }
}
