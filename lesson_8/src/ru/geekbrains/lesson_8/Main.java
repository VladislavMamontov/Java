package ru.geekbrains.lesson_8;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
//    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();


    public static void main(String[] args) {
        XOGame game = new XOGame();


//        initMap();
//        printMap();
//
//        while (true) {
//            humanTurn();
//            printMap();
//            if (checkWin(DOT_X)){
//                System.out.println("Победил человек");
//                break;
//            }
//            if (isMapFull()) {
//                System.out.println("Ничья");
//                break;
//            }
//            aiTurn();
//            printMap();
//            if (checkWin(DOT_O)){
//                System.out.println("Победил ИИ");
//                break;
//            }
//            if (isMapFull()) {
//                System.out.println("Ничья");
//                break;
//            }
//
//        }
//        sc.close();


    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = DOT_EMTY;
            }

        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%d ", i + 1);
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

//    public static void humanTurn() {
//        int x, y;
//        do {
//            System.out.println("Введите координаты в формате X Y");
//            x = sc.nextInt() - 1;
//            y = sc.nextInt() - 1;
//        } while (!isCellValid(x, y));
//        map[y][x] = DOT_X;
//    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMTY) return true;
        else return false;
    }



    public static boolean checkWin(char symb) {


        //Цикл для проверки строк
        int numberOfSymb = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map [i] [j] == symb) numberOfSymb ++;
                if (numberOfSymb == DOTS_TO_WIN) return true;
                if (map [i] [j] != symb) numberOfSymb = 0;
            }

            numberOfSymb = 0;
        }


        //Цикл для проверки столбцов
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map [j] [i] == symb) numberOfSymb ++;
                if (numberOfSymb == DOTS_TO_WIN) return true;
                if (map [j] [i] != symb) numberOfSymb = 0;
            }
            numberOfSymb = 0;
        }

        //Цикл для проверки первой диагонали
        for (int i = 0; i < SIZE; i++) {
            if (map [i] [i] == symb) numberOfSymb ++;
            if (numberOfSymb == DOTS_TO_WIN) return true;
            if (map [i] [i] != symb) numberOfSymb = 0;

        }
        numberOfSymb = 0;
        //Цикл для проверки второй диагонали
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i+j+1 == SIZE && map [j] [i] == symb) numberOfSymb ++;
                if (numberOfSymb == DOTS_TO_WIN) return true;
                if (i+j+1 == SIZE && map [j] [i] != symb) numberOfSymb = 0;
            }

        }
        return false;

    }

    public static boolean isMapFull() {
        for (int i = 0; i <SIZE ; i++) {
            for (int j = 0; j <SIZE; j++) {
                if (map [i][j] == DOT_EMTY) return false;
            }

        }
        return true;
    }
}


