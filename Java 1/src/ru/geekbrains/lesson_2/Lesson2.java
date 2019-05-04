package ru.geekbrains.lesson_2;

import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {
        changeNum ();
        setArr ();
        multiplicationArr ();
        fillingArr ();
        minAndMaxNum ();
        System.out.println(checkBalance(new int[] {1,3,2,2,8}));
//        moveArr(new int[] {1,3,2,2,8}, 1);
    }

        // 1.Задать целочисленный массив, состоящий из элементов 0 и 1. С помощью цикла и условия заменить 0 на 1, 1 на 0.
        public static void changeNum () {
            int[] arr = {0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0};
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    arr[i] = 1;
                } else {
                    arr[i] = 0;
                }
            }
            System.out.println(Arrays.toString(arr));
        }


        //2.Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        public static void setArr () {
            int[] arr = new int[8];
            for (int j = 0; j < 8; j++) {
                arr[j] = j * 3;
            }

            System.out.println(Arrays.toString(arr));
        }
        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
        // и числа меньшие 6 умножить на 2;
        public static void multiplicationArr () {
            int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            for (int q = 0; q < arr.length; q++) {
                if (arr[q] < 6) arr[q] *= 2;
            }
            System.out.println(Arrays.toString(arr));
        }
        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
        //одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        public static void fillingArr () {
            int[][] arr = new int[4][4];
            for (int i = 0; i < arr.length ; i++) {
                for (int j = 0; j < arr.length; j++){
                    if (i==j || (i + j + 1 == arr.length)) arr [i] [j] = 1;
                    System.out.print(arr [i] [j] + " ");
                }
                System.out.println();

            }

        }
        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        public static void minAndMaxNum () {
            int[] arr = {0, -3, 5, 150, 1000, -650};

            for (int m = 0; m < arr.length; m++) {
                int counterMin = 0;
                int counterMax = 0;
                for (int n = 0; n < arr.length; n++) {
                    if (arr[m] >= arr[n]) counterMax++;
                    if (arr[m] <= arr[n]) counterMin++;
                }
                if (counterMax == arr.length) System.out.println("Максимальное значение: " + arr[m]);
                if (counterMin == arr.length) System.out.println("Минимальное значение: " + arr[m]);
            }
        }

        //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.

        public static boolean checkBalance (int [] arr) {
        int summ1 = 0;
        int summ2 = 0;
            for (int i = 0; i <arr.length ; i++) summ1 += arr[i];
            for (int j = 0; j <arr.length ; j++){
                summ2 += arr [j];
                summ1 -= arr[j];
                if (summ1 == summ2) return true;
            } return false;

            }

        //7. **** Написать метод, которому на вход подается одномерный массив и число n
        // (может быть положительным, или отрицательным), при этом метод должен сместить
        // все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
//            public static void moveArr (int [] arr, int n){
//            int z;
//                for (int i = 0; i <arr.length ; i++) {
//                    if (n > 0) {
//                        for (int q = 1; q <=n; q++ ){
//                            z = arr [i+q];
//                            arr [i+q] = arr [i];
//                        }
//                    }
//
//
//                }
//
//            }





}