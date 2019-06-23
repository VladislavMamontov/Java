package Lesson_3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        uniqueWords("Россия", "США", "Германия", "Канада", "Бельгия", "Бельгия", "США", "Украина",
                "Польша", "США", "Англия", "Индия", "Китай", "Россия");

        Phonebook phonebook = new Phonebook();
        phonebook.add("Петров", 111222);
        phonebook.add("Петров", 111333);
        phonebook.add("Иванов", 111444);
        phonebook.get("Петров");
        phonebook.get("Иванов");
        phonebook.get("Сидоров");



    }

    static void uniqueWords(String... words) {
        HashMap<String, Integer> uniqueWords = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (uniqueWords.containsKey(words[i])) {
                uniqueWords.put(words[i], uniqueWords.get(words[i]) + 1);
            } else {
                uniqueWords.put(words[i], 1);
            }
        }
        for (Map.Entry<String, Integer> w : uniqueWords.entrySet()) {
            System.out.println(w.getKey() + " - " + w.getValue());
        }
    }

    private static class Phonebook {
        private HashMap<String, LinkedList<Integer>> book;

        public Phonebook(){
            book = new HashMap<>();
        }

        void add(String surname, int phone){
            if (book.containsKey(surname)){
                book.get(surname).add(phone);
            }else{
                book.put(surname, new LinkedList<Integer>());
                book.get(surname).add(phone);
            }
        }

        void get (String surname){
            if (!book.containsKey(surname)) System.out.println("Фамилия " + surname + " отсутствует");
            else {
                System.out.println("Номера телефонов по фамилии " + surname);
                for (Integer i:book.get(surname)) {
                    System.out.println(i);
                }
            }
        }

    }

}

