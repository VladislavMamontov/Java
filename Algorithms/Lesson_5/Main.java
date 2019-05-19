package Lesson_5;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(exponent(5, 4));
        System.out.println(exponentRec(5, 4));
//        System.out.println(towerInitialization(3));

    }

    public static long exponent (int a, int b){
        long result = 1;
        if (b % 2 == 0){
            while (b / 2 > 0){
                result *= a;
                b--;
            }
            return result * a;
        } else {
            while (b > 0){
                result *= a;
                b --;
            }
            return result;
        }
    }
    public static long exponentRec (int a, int b){
        if (b==1) return a;
        return a * exponentRec(a, b-1);
    }

//    public static LinkedList<Integer> towerInitialization (int rings){
//        LinkedList<Integer> towerFrom = new LinkedList<>();
//        LinkedList<Integer> towerBuf = new LinkedList<>();
//        LinkedList<Integer> towerTo = new LinkedList<>();
//
//        for (int i = rings; i > 0 ; i--) towerFrom.addLast(i);
//        LinkedList[] arrayOfTowers = {towerFrom, towerBuf, towerTo};
//        return towers(arrayOfTowers, rings, 0, 1, 2);
//
//    }
//    public static LinkedList<Integer> towers (LinkedList[] arrayOfTowers, int rings, int indexFrom,
//                                              int indexBuf, int indexTo){
//        if (arrayOfTowers[0].size() == 1 && arrayOfTowers[2].size() == rings - 1 && arrayOfTowers[1].size() == 0){
//            arrayOfTowers[2].addLast(arrayOfTowers[0].pollLast());
//            return arrayOfTowers[2];
//        }
//        arrayOfTowers[indexTo].addLast(arrayOfTowers[indexFrom].pollLast());
//        int tmp = indexTo;
//        indexTo = indexBuf;
//        indexBuf = tmp;
//        arrayOfTowers[indexTo].addLast(arrayOfTowers[indexFrom].pollLast());
//        tmp = indexFrom;
//        indexFrom = indexBuf;
//        indexBuf = tmp;
//        return towers(arrayOfTowers, rings, indexFrom, indexBuf, indexTo);
//    }
}

