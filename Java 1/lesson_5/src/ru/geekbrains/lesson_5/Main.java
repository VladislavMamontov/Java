package ru.geekbrains.lesson_5;

public class Main {

    public static void main(String[] args) {
	Person [] person = new Person[5];
	person[0] = new Person("Vladimir", "Manager", 3405050, 20000, 25 );
    person[1] = new Person("Viktor", "Engineer", 3405051, 50000, 35 );
    person[2] = new Person("Anna", "Accountant", 3405052, 35000, 30 );
    person[3] = new Person("Anton", "Programmer", 3405053, 60000, 45 );
    person[4] = new Person("Aleksandr", "Director", 3405054, 80000, 50 );

        for (int i = 0; i <person.length ; i++) {
            if (person [i].getAge() > 40) person[i].info();

        }


    }
}
