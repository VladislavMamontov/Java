package ru.geekbrains.lesson_3;

import java.util.Random;
import java.util.Scanner;

public class lesson3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random word = new Random();
        int wordNum = word.nextInt(words.length);
        String trueWord = words [wordNum];
        String lastAttempt;
        do {
            System.out.println();
            System.out.println();
            System.out.println("Угадайте слово из списка:apple, orange, lemon, banana, apricot, avocado, broccoli, carrot," +
                    " cherry, garlic, grape, melon, leak, kiwi, mango, mushroom, nut, olive, pea," +
                    " peanut, pear, pepper, pineapple, pumpkin, potato");

            String attempt = sc.nextLine();
            lastAttempt = attempt;
            System.out.println("Совпадение букв:");
            for (int i = 0; i < 15; i++) {
                char letter1;
                char letter2;
                if (i < trueWord.length()) letter1 = trueWord.charAt(i);
                else letter1 = '#';
                if (i < attempt.length()) letter2 = attempt.charAt(i);
                else letter2 = '#';
                if (letter1 == letter2) System.out.print(letter2);
                else System.out.print("#");
            }

        } while (!trueWord.equals(lastAttempt));
        System.out.println();
        System.out.println("Вы угадали");
        sc.close();



    }
}
