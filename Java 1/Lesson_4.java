package ru.geekbrains.lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Lesson_4 {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)){
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)){
                System.out.println("Победил ИИ");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

        }
        sc.close();


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

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMTY) return true;
        else return false;
    }

    public static boolean aiTurn() {
//        int x, y;
//        do {
//            x = rand.nextInt(SIZE);
//            y = rand.nextInt(SIZE);
//        } while (!isCellValid(x, y));
//        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
//        map[y][x] = DOT_O;

        //Доработанный ИИ
        //Цикл для проверки строк
        int numberOfSymb = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map [i] [j] == DOT_X) numberOfSymb ++;
                if (numberOfSymb == DOTS_TO_WIN - 1 && map[i][j] == DOT_EMTY) {
                    map[i][j] = DOT_O;
                    System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                    return true;
                }
                if (map [i] [j] != DOT_X) numberOfSymb = 0;
            }

            numberOfSymb = 0;
        }
        //Цикл для проверки столбцов
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map [j] [i] == DOT_X) numberOfSymb ++;
                if (numberOfSymb == DOTS_TO_WIN - 1 && map[j][i] == DOT_EMTY) {
                    map[j][i] = DOT_O;
                    System.out.println("Компьютер походил в точку " + (i + 1) + " " + (j + 1));
                    return true;
                }
                if (map [j] [i] != DOT_X) numberOfSymb = 0;
            }

            numberOfSymb = 0;
        }

        //Цикл для проверки первой диагонали
        for (int i = 0; i < SIZE; i++) {
            if (map [i] [i] == DOT_X) numberOfSymb++;
            if (numberOfSymb == DOTS_TO_WIN - 1 && map [i] [i] == DOT_EMTY ){
                map [i] [i] = DOT_O;
                System.out.println("Компьютер походил в точку " + (i + 1) + " " + (i + 1));
                return true;
            }
            if (map [i] [i] != DOT_X) numberOfSymb = 0;
        }
        numberOfSymb = 0;

        //Цикл для проверки второй диагонали
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i + j + 1 == SIZE && map [i] [j] == DOT_X) numberOfSymb++;
                if (i + j + 1 == SIZE && numberOfSymb == DOTS_TO_WIN - 1 && map [i] [j] == DOT_EMTY) {
                    map [i] [j] = DOT_O;
                    System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                    return true;
                }
                if (i + j + 1 == SIZE && map [i] [j] != DOT_X) numberOfSymb = 0;
            }
        }
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
        return false;
    }

    public static boolean checkWin(char symb) {
//        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
//        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
//        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
//        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
//        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
//        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
//        if (map[0][2] == symb && map[1][1] == symb && map[2][0] == symb) return true;
//        return false;

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




